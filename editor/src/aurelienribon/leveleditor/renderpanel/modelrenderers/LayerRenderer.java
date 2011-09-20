package aurelienribon.leveleditor.renderpanel.modelrenderers;

import aurelienribon.leveleditor.models.LayerChild;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.utils.ObservableList.ListChangedListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class LayerRenderer {
	private final LayerModel model;
	private final Map<LayerChild, LayerChildRenderer> childrenMap = new LinkedHashMap<LayerChild, LayerChildRenderer>();

	public LayerRenderer(LayerModel model) {
		this.model = model;
		model.addListChangedListener(modelListChangedListener);
	}

	public void render(SpriteBatch batch) {
		if (model.isVisible())
			for (LayerChild childModel : model.getAll())
				childrenMap.get(childModel).render(batch);
	}

	private final ListChangedListener<LayerChild> modelListChangedListener = new ListChangedListener<LayerChild>() {
		@Override
		public void elementAdded(Object source, int idx, LayerChild elem) {
			assert !childrenMap.containsKey(elem);
			if (elem instanceof SpriteModel) {
				LayerChildRenderer childRdr = new SpriteRenderer((SpriteModel)elem);
				childrenMap.put(elem, childRdr);
			}
		}

		@Override
		public void elementRemoved(Object source, int idx, LayerChild elem) {
			assert childrenMap.containsKey(elem);
			childrenMap.remove(elem);
		}
	};
}
