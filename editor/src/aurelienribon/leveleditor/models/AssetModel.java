package aurelienribon.leveleditor.models;

import aurelienribon.leveleditor.models.behaviors.Hideable;
import aurelienribon.leveleditor.models.behaviors.Renameable;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import aurelienribon.utils.ObservableList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AssetModel extends ObservableList<ObservableList> implements Changeable, Renameable, Hideable {
	private final AssetInfo info;
	private float x;
	private float y;
	private float width;
	private float height;
	private float rotation;

	public AssetModel(AssetInfo info) {
		this.info = info;
	}

	public AssetInfo getInfo() {
		return info;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public float getRotation() {
		return rotation;
	}

	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
		firePropertyChanged("x");
		firePropertyChanged("y");
	}

	public void setSize(float w, float h) {
		this.width = w;
		this.height = h;
		firePropertyChanged("width");
		firePropertyChanged("height");
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
		firePropertyChanged("rotation");
	}

	// -------------------------------------------------------------------------
	// Changeable impl.
	// -------------------------------------------------------------------------

	private final List<ChangeListener> changeListeners = new ArrayList<ChangeListener>(3);

	@Override
	public void addPropertyChangeListener(ChangeListener l) {
		changeListeners.add(l);
	}

	@Override
	public void removePropertyChangeListener(ChangeListener l) {
		changeListeners.add(l);
	}

	private void firePropertyChanged(String propertyName) {
		for (ChangeListener listener : changeListeners)
			listener.propertyChanged(this, propertyName);
	}

	// -------------------------------------------------------------------------
	// Renameable impl.
	// -------------------------------------------------------------------------

	private String name = "<unamed>";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		firePropertyChanged("name");
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
		firePropertyChanged("visible");
	}
}
