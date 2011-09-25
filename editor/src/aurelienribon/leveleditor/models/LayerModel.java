package aurelienribon.leveleditor.models;

import aurelienribon.leveleditor.models.behaviors.Hideable;
import aurelienribon.leveleditor.models.behaviors.Nameable;
import aurelienribon.leveleditor.models.behaviors.Selectable;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import aurelienribon.utils.InnerChangeableObject;
import aurelienribon.utils.ObservableList;
import aurelienribon.utils.ObservableListsHolder;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class LayerModel implements Changeable, ObservableListsHolder, Nameable, Hideable, Selectable {
	private final ObservableList<SpriteModel> sprites = new ObservableList<SpriteModel>(this);

	public ObservableList<SpriteModel> getSprites() {
		return sprites;
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
	// ObservableListsHolder impl.
	// -------------------------------------------------------------------------

	@Override
	public int getObservableListCount() {
		return 1;
	}

	@Override
	public ObservableList getObservableList(int idx) {
		return sprites;
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

	// -------------------------------------------------------------------------
	// Selectable impl.
	// -------------------------------------------------------------------------

	private boolean selected = false;

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		this.selected = selected;
		cho.firePropertyChanged(this, "selected");
	}
}
