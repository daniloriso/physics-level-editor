package aurelienribon.leveleditor.models;

import aurelienribon.leveleditor.models.behaviors.Hideable;
import aurelienribon.leveleditor.models.behaviors.Nameable;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import aurelienribon.utils.InnerChangeableObject;
import aurelienribon.utils.ObservableList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class LayerModel extends ObservableList<LayerChild> implements Changeable, Nameable, Hideable {
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
	// Nameable impl.
	// -------------------------------------------------------------------------

	private String name;

	@Override
	public String getName() {
		if (name == null || name.equals(""))
			name = "<unamed layer>";
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		cho.firePropertyChanged(this, "name");
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
		cho.firePropertyChanged(this, "visible");
	}
}
