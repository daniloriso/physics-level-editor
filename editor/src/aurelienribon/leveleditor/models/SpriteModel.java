package aurelienribon.leveleditor.models;

import aurelienribon.leveleditor.models.behaviors.Drawable;
import aurelienribon.leveleditor.models.behaviors.Hideable;
import aurelienribon.leveleditor.models.behaviors.Renameable;
import aurelienribon.leveleditor.models.behaviors.Resizable;
import aurelienribon.leveleditor.models.behaviors.Rotatable;
import aurelienribon.leveleditor.models.behaviors.Selectable;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import aurelienribon.utils.InnerChangeableObject;
import aurelienribon.utils.ObservableList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class SpriteModel extends ObservableList<SpriteChild>
	implements LayerChild, Drawable, Selectable, Resizable, Rotatable, Changeable, Renameable, Hideable {

	public SpriteModel(AssetInfo info) {
		this.info = info;
	}

	// -------------------------------------------------------------------------
	// Drawable impl.
	// -------------------------------------------------------------------------

	private final AssetInfo info;

	@Override
	public AssetInfo getAsset() {
		return info;
	}

	// -------------------------------------------------------------------------
	// Positionable impl.
	// -------------------------------------------------------------------------

	private float x;
	private float y;

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		cho.firePropertyChanged(this, "x");
		cho.firePropertyChanged(this, "y");
	}

	// -------------------------------------------------------------------------
	// Resizable impl.
	// -------------------------------------------------------------------------

	private float width;
	private float height;

	@Override
	public float getWidth() {
		return width;
	}

	@Override
	public float getHeight() {
		return height;
	}

	@Override
	public void setSize(float w, float h) {
		this.width = w;
		this.height = h;
		cho.firePropertyChanged(this, "width");
		cho.firePropertyChanged(this, "height");
	}

	// -------------------------------------------------------------------------
	// Rotatable impl.
	// -------------------------------------------------------------------------

	private float rotation;

	@Override
	public float getRotation() {
		return rotation;
	}

	@Override
	public void setRotation(float rotation) {
		this.rotation = rotation;
		cho.firePropertyChanged(this, "rotation");
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

	private String name;

	@Override
	public String getName() {
		if (name == null || name.equals(""))
			name = "<unamed - " + info.getName() + ">";
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
