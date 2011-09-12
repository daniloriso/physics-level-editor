package aurelienribon.leveleditor.renderpanel.modelrenderers;

import aurelienribon.leveleditor.models.LayerChild;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.utils.ObservableList.ListChangedListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class LayerRenderer {
	private final LayerModel model;
	private final List<LayerChildRenderer> children = new ArrayList<LayerChildRenderer>();
	private final Map<LayerChild, LayerChildRenderer> childrenMap = new HashMap<LayerChild, LayerChildRenderer>();

	public LayerRenderer(LayerModel model) {
		this.model = model;
		model.addListChangedListener(modelListChangedListener);
	}

	public void render(SpriteBatch batch) {
		if (model.isVisible())
			for (LayerChildRenderer child : children)
				child.render(batch);
	}

	private final ListChangedListener<LayerChild> modelListChangedListener = new ListChangedListener<LayerChild>() {
		@Override public void elementAdded(Object source, int idx, LayerChild elem) {
			assert !childrenMap.containsKey(elem);
			if (elem instanceof SpriteModel) {
				LayerChildRenderer childRdr = new SpriteRenderer((SpriteModel)elem);
				children.add(childRdr);
				childrenMap.put(elem, childRdr);
			}
		}

		@Override public void elementRemoved(Object source, int idx, LayerChild elem) {
			assert childrenMap.containsKey(elem);
			children.remove(childrenMap.remove(elem));
		}
	};
}
