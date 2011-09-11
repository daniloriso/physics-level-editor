package aurelienribon.leveleditor;

import aurelienribon.utils.ObservableList;
import aurelienribon.leveleditor.models.LayerModel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class LayersManager extends ObservableList<LayerModel> {
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
	}

	public LayerModel getWorkingLayer() {
		return workingLayer;
	}

	public void setWorkingLayer(LayerModel workingLayer) {
		this.workingLayer = workingLayer;
	}
}
