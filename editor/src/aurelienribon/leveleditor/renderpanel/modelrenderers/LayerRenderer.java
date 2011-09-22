package aurelienribon.leveleditor.renderpanel.modelrenderers;

import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.utils.ObservableList.ListChangeListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class LayerRenderer {
	private final LayerModel model;
	private final Map<SpriteModel, SpriteRenderer> spritesMap = new LinkedHashMap<SpriteModel, SpriteRenderer>();

	public LayerRenderer(LayerModel model) {
		this.model = model;
		model.getSprites().addListChangedListener(modelSpritesChangedListener);
	}

	public void render(SpriteBatch batch) {
		if (model.isVisible())
			for (SpriteModel sprite : model.getSprites().getAll())
				spritesMap.get(sprite).render(batch);
	}

	private final ListChangeListener<SpriteModel> modelSpritesChangedListener = new ListChangeListener<SpriteModel>() {
		@Override
		public void elementAdded(Object source, int idx, SpriteModel elem) {
			assert !spritesMap.containsKey(elem);
			SpriteRenderer spriteRdr = new SpriteRenderer(elem);
			spritesMap.put(elem, spriteRdr);
		}

		@Override
		public void elementRemoved(Object source, int idx, SpriteModel elem) {
			assert spritesMap.containsKey(elem);
			spritesMap.remove(elem);
		}
	};
}
