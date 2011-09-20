package aurelienribon.leveleditor.models;

import aurelienribon.leveleditor.models.behaviors.Hideable;
import aurelienribon.leveleditor.models.behaviors.Renameable;
import aurelienribon.leveleditor.models.behaviors.Delimitable;
import aurelienribon.leveleditor.models.behaviors.Selectable;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import aurelienribon.utils.InnerChangeableObject;
import aurelienribon.utils.ObservableList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class LayerModel extends ObservableList<LayerChild> implements Changeable, Renameable, Hideable {
	public Selectable pickChild(float x, float y) {
		for (int i=size()-1; i>=0; i--)
			if (get(i) instanceof Selectable && isOver((Selectable)get(i), x, y))
				return (Selectable)get(i);
		return null;
	}

	private boolean isOver(Delimitable c, float x, float y) {
		return c.getX() <= x && x <= c.getX() + c.getWidth()
			&& c.getY() <= y && y <= c.getY() + c.getHeight();
	}

	// -------------------------------------------------------------------------
	// Changeable impl.
	// -------------------------------------------------------------------------

	private final InnerChangeableObject cho = new InnerChangeableObject();

	@Override
	public void addChangeListener(ChangeListener l) {
		cho.addChangeListener(l);
	}

	@Override
	public void removeChangeListener(ChangeListener l) {
		cho.removeChangeListener(l);
	}

	// -------------------------------------------------------------------------
	// Renameable impl.
	// -------------------------------------------------------------------------

	private String name = "";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name != null ? name : "";
		cho.firePropertyChanged("name");
	}

	// -------------------------------------------------------------------------
	// Hideable impl.
	// -------------------------------------------------------------------------

	private boolean visible = true;

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
		cho.firePropertyChanged("visible");
	}
}
