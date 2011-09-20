package aurelienribon.leveleditor;

import aurelienribon.utils.ObservableList;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class LayersManager extends ObservableList<LayerModel> implements Changeable {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final LayersManager instance = new LayersManager();
	public static LayersManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Content
	// -------------------------------------------------------------------------

	private LayerModel workingLayer;

	public LayersManager() {
		LayerModel layer = new LayerModel();
		layer.setName("Layer 1");
		add(layer);
		workingLayer = layer;

		addListChangedListener(new ListChangedListener() {
			@Override public void elementAdded(Object source, int idx, Object elem) {}
			@Override public void elementRemoved(Object source, int idx, Object elem) {
				if (elem == workingLayer)
					setWorkingLayer(null);
			}
		});
	}

	public LayerModel getWorkingLayer() {
		return workingLayer;
	}

	public void setWorkingLayer(LayerModel workingLayer) {
		this.workingLayer = workingLayer;
		firePropertyChanged("workingLayer");
	}

	// -------------------------------------------------------------------------
	// Changeable impl.
	// -------------------------------------------------------------------------

	private final List<ChangeListener> changeListeners = new ArrayList<ChangeListener>(3);

	@Override
	public void addChangeListener(ChangeListener l) {
		changeListeners.add(l);
	}

	@Override
	public void removeChangeListener(ChangeListener l) {
		changeListeners.add(l);
	}

	private void firePropertyChanged(String propertyName) {
		for (ChangeListener listener : changeListeners)
			listener.propertyChanged(this, propertyName);
	}
}
