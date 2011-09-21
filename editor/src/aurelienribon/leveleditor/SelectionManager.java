package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.utils.ChangeableObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SelectionManager extends ChangeableObject {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final SelectionManager instance = new SelectionManager();
	public static SelectionManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Selected Objects
	// -------------------------------------------------------------------------

	private final List<Object> selectedObjects = new ArrayList<Object>();

	public List<Object> getSelectedObjects() {
		return Collections.unmodifiableList(selectedObjects);
	}

	public void setSelectedObject(Object obj) {
		selectedObjects.clear();
		if (obj != null)
			selectedObjects.add(obj);
		firePropertyChanged("selectedObjects");

		if (obj instanceof LayerModel)
			LayersManager.instance().setWorkingLayer((LayerModel)obj);
	}

	public void setSelectedObjects(List<Object> objs) {
		assert !objs.contains(null);
		selectedObjects.clear();
		selectedObjects.addAll(objs);
		firePropertyChanged("selectedObjects");

		if (objs.size() == 1 && objs.get(0) instanceof LayerModel)
			LayersManager.instance().setWorkingLayer((LayerModel)objs.get(0));
	}

	public void addSelectedObject(Object obj) {
		if (obj == null)
			return;
		if (selectedObjects.contains(obj)) {
			selectedObjects.remove(obj);
		} else {
			selectedObjects.add(obj);
		}
		firePropertyChanged("selectedObjects");
	}

	public void addSelectedObjects(List<Object> objs) {
		for (Object obj : objs) {
			if (obj == null)
				continue;
			if (selectedObjects.contains(obj)) {
				selectedObjects.remove(obj);
			} else {
				selectedObjects.add(obj);
			}
		}
		firePropertyChanged("selectedObjects");
	}

	public void removeSelectedObject(Object obj) {
		assert obj != null;
		selectedObjects.remove(obj);
		firePropertyChanged("selectedObjects");
	}

	public void removeSelectedObjects(List<Object> objs) {
		assert !objs.contains(null);
		selectedObjects.removeAll(objs);
		firePropertyChanged("selectedObjects");
	}

	public boolean areSelectedObjectsSameType() {
		if (selectedObjects.isEmpty())
			return true;
		Class type = selectedObjects.get(0).getClass();
		for (Object obj : selectedObjects)
			if (obj.getClass() != type)
				return false;
		return true;
	}

	// -------------------------------------------------------------------------
	// MouseOver Object
	// -------------------------------------------------------------------------

	private Object mouseOverObject;

	public Object getMouseOverObject() {
		return mouseOverObject;
	}

	public void setMouseOverObject(Object mouseOverObject) {
		if (mouseOverObject != this.mouseOverObject) {
			this.mouseOverObject = mouseOverObject;
			firePropertyChanged("mouseOverObject");
		}
	}
}
