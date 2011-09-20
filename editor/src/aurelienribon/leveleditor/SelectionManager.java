package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.utils.ChangeableObject;

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
	// Content
	// -------------------------------------------------------------------------

	private Object selectedObject;
	private Object mouseOverObject;

	public Object getSelectedObject() {
		return selectedObject;
	}

	public void setSelectedObject(Object selectedObject) {
		if (selectedObject == this.selectedObject)
			return;
		this.selectedObject = selectedObject;
		if (selectedObject instanceof LayerModel)
			LayersManager.instance().setWorkingLayer((LayerModel)selectedObject);
		firePropertyChanged("selectedObject");
	}

	public Object getMouseOverObject() {
		return mouseOverObject;
	}

	public void setMouseOverObject(Object mouseOverObject) {
		if (mouseOverObject == this.mouseOverObject)
			return;
		this.mouseOverObject = mouseOverObject;
		firePropertyChanged("mouseOverObject");
	}
}
