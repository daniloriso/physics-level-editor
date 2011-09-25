package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.models.behaviors.Selectable;
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

	private final List<SpriteModel> selectedSprites = new ArrayList<SpriteModel>();
	private final List<Object> selectedObjects = new ArrayList<Object>();

	public List<SpriteModel> getSelectedSprites() {
		return Collections.unmodifiableList(selectedSprites);
	}

	public List<Object> getSelectedObjects() {
		return Collections.unmodifiableList(selectedObjects);
	}

	/**
	 * Adds an object to the selection list. if already selected, removes it
	 * from the list instead.
	 * @param obj The object to select
	 * @param override True if the selection lists must be cleared first
	 */
	public void select(Object obj, boolean override) {
		if (override) {
			for (Object selObj : selectedObjects)
				if (selObj instanceof Selectable)
					((Selectable)selObj).setSelected(false);
			selectedSprites.clear();
			selectedObjects.clear();
		}

		if (obj == null) {
			firePropertyChanged("selectedObjects");
			return;
		}

		if (selectedObjects.contains(obj)) {
			if (obj instanceof SpriteModel)
				selectedSprites.remove((SpriteModel)obj);
			selectedObjects.remove(obj);
			if (obj instanceof Selectable)
				((Selectable)obj).setSelected(false);
		} else {
			if (obj instanceof SpriteModel)
				selectedSprites.add((SpriteModel)obj);
			selectedObjects.add(obj);
			if (obj instanceof Selectable)
				((Selectable)obj).setSelected(true);
		}

		firePropertyChanged("selectedObjects");

		if (obj instanceof LayerModel)
			LayersManager.instance().setWorkingLayer((LayerModel)obj);
	}

	/**
	 * Gets the common class of all the objects, or null if the objects are not
	 * all from the same class, or if the selection list is empty.
	 */
	public Class getSelectedObjectsType() {
		if (selectedObjects.isEmpty())
			return null;
		Class type = selectedObjects.get(0).getClass();
		for (Object obj : selectedObjects)
			if (obj.getClass() != type)
				return null;
		return type;
	}

	// -------------------------------------------------------------------------
	// MouseOver Object
	// -------------------------------------------------------------------------

	private SpriteModel mouseOverSprite;

	public SpriteModel getMouseOverSprite() {
		return mouseOverSprite;
	}

	public void setMouseOverSprite(SpriteModel mouseOverSprite) {
		this.mouseOverSprite = mouseOverSprite;
	}
}
