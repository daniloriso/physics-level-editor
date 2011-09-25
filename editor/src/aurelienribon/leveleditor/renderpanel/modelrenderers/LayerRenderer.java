package aurelienribon.leveleditor.renderpanel.modelrenderers;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.renderpanel.MainRenderer;
import aurelienribon.utils.ObservableList.ListChangeListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class LayerRenderer {
	private final MainRenderer rdr;
	private final LayerModel model;
	private final Map<SpriteModel, SpriteRenderer> spritesMap = new HashMap<SpriteModel, SpriteRenderer>();

	public LayerRenderer(MainRenderer rdr, LayerModel model) {
		this.rdr = rdr;
		this.model = model;
		model.getSprites().addListChangedListener(modelSpritesChangedListener);
	}

	public void render(GL10 gl, SpriteBatch batch) {
		if (!model.isVisible())
			return;

		for (SpriteModel sprite : model.getSprites().getAll())
			spritesMap.get(sprite).render(batch);

		if (model.isSelected())
			for (SpriteModel sprite : model.getSprites().getAll())
				rdr.getBoundingBoxDrawer().drawBoundingBox(gl, sprite, Color.RED);

		for (SpriteModel sprite : model.getSprites().getAll())
			spritesMap.get(sprite).renderOverlay(gl);
	}

	private final ListChangeListener<SpriteModel> modelSpritesChangedListener = new ListChangeListener<SpriteModel>() {
		@Override
		public void elementAdded(Object source, int idx, SpriteModel elem) {
			assert !spritesMap.containsKey(elem);
			SpriteRenderer spriteRdr = new SpriteRenderer(rdr, elem);
			spritesMap.put(elem, spriteRdr);
		}

		@Override
		public void elementRemoved(Object source, int idx, SpriteModel elem) {
			assert spritesMap.containsKey(elem);
			spritesMap.remove(elem);
		}
	};
}
