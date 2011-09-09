package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.LayerModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class LayersManager {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final LayersManager instance = new LayersManager();
	public static LayersManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Content
	// -------------------------------------------------------------------------

	private final List<LayerModel> layers = new ArrayList<LayerModel>();

	public List<LayerModel> getLayersList() {
		return Collections.unmodifiableList(layers);
	}

	public LayerModel getLayer(int idx) {
		assert 0 <= idx && idx < layers.size();
		return layers.get(idx);
	}

	public void addLayer(LayerModel layer) {
		assert layer != null;
		assert !layers.contains(layer);
		layers.add(layer);
		fireLayerAdded(layer);
	}

	public void removeLayer(int idx) {
		assert 0 <= idx && idx < layers.size();
		LayerModel layer = layers.remove(idx);
		fireLayerRemoved(layer);
	}

	public void moveUp(LayerModel asset) {
		assert layers.contains(asset);
		int idx = layers.indexOf(asset);
		if (idx > 0)
			Collections.swap(layers, idx, idx-1);
	}

	public void moveDown(LayerModel asset) {
		assert layers.contains(asset);
		int idx = layers.indexOf(asset);
		if (idx < layers.size()-1)
			Collections.swap(layers, idx, idx+1);
	}

	public void notifyLayersUpdated() {
		fireLayersUpdated();
	}

	// -------------------------------------------------------------------------
	// Events
	// -------------------------------------------------------------------------

	private final EventListenerList listeners = new EventListenerList();

	public interface Listener extends EventListener {
		public void layerAdded(LayerModel layer);
		public void layerRemoved(LayerModel layer);
		public void layersUpdated();
	}

	public void addListener(Listener listener) {
		listeners.add(Listener.class, listener);
	}

	public void removeListener(Listener listener) {
		listeners.remove(Listener.class, listener);
	}

	private void fireLayerAdded(LayerModel layer) {
		for (Listener listener : listeners.getListeners(Listener.class))
			listener.layerAdded(layer);
	}

	private void fireLayerRemoved(LayerModel layer) {
		for (Listener listener : listeners.getListeners(Listener.class))
			listener.layerRemoved(layer);
	}

	private void fireLayersUpdated() {
		for (Listener listener : listeners.getListeners(Listener.class))
			listener.layersUpdated();
	}
}
