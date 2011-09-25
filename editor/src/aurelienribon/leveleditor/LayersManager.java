package aurelienribon.leveleditor;

import aurelienribon.utils.ObservableList;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.utils.ChangeableObject;
import aurelienribon.utils.ObservableListsHolder;
import aurelienribon.utils.ObservableList.ListChangeListener;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class LayersManager extends ChangeableObject implements ObservableListsHolder {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final LayersManager instance = new LayersManager();
	public static LayersManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Content
	// -------------------------------------------------------------------------

	private final ObservableList<LayerModel> list = new ObservableList<LayerModel>(this);
	private LayerModel workingLayer;

	public LayersManager() {
		LayerModel layer = new LayerModel();
		layer.setName("Layer 1");
		list.add(layer);
		workingLayer = layer;

		list.addListChangedListener(new ListChangeListener() {
			@Override public void elementAdded(Object source, int idx, Object elem) {}
			@Override public void elementRemoved(Object source, int idx, Object elem) {
				if (elem == workingLayer)
					setWorkingLayer(null);
			}
		});
	}

	public ObservableList<LayerModel> getList() {
		return list;
	}

	public LayerModel getWorkingLayer() {
		return workingLayer;
	}

	public void setWorkingLayer(LayerModel workingLayer) {
		this.workingLayer = workingLayer;
		firePropertyChanged("workingLayer");
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
		return list;
	}
}
