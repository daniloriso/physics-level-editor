package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.AssetsManager;
import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.TempSpriteManager;
import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.renderpanel.drawers.BoundingBoxDrawer;
import aurelienribon.leveleditor.renderpanel.drawers.PrimitiveDrawer;
import aurelienribon.leveleditor.renderpanel.modelrenderers.LayerRenderer;
import aurelienribon.leveleditor.renderpanel.modelrenderers.SpriteRenderer;
import aurelienribon.libgdx.Renderer2D;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.ObservableList.ListChangeListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class MainRenderer extends Renderer2D {
	private final SpriteBatch batch = new SpriteBatch();
	private final PrimitiveDrawer drawer = new PrimitiveDrawer();
	private final BoundingBoxDrawer bbDrawer = new BoundingBoxDrawer(this, drawer);
	private final Map<LayerModel, LayerRenderer> layerRdrsMap = new LinkedHashMap<LayerModel, LayerRenderer>();
	private SpriteRenderer tempSpriteRdr;

	public MainRenderer() {
		setWorldViewport(20, 20);
		setWorldViewportUniformToFill();

		for (LayerModel layer : LayersManager.instance().getList().getAll())
			layerRdrsMap.put(layer, new LayerRenderer(layer));
			
		LayersManager.instance().getList().addListChangedListener(layersListChangedListener);
		AssetsManager.instance().getList().addListChangedListener(assetsListChangedListener);
		TempSpriteManager.instance().addChangeListener(tempSpriteChangeListener);
	}

	private final ListChangeListener<LayerModel> layersListChangedListener = new ListChangeListener() {
		@Override
		public void elementAdded(Object source, int idx, Object elem) {
			LayerModel layer = (LayerModel)elem;
			layerRdrsMap.put(layer, new LayerRenderer(layer));
		}

		@Override
		public void elementRemoved(Object source, int idx, Object elem) {
			LayerModel layer = (LayerModel)elem;
			layerRdrsMap.remove(layer);
		}
	};

	private final ListChangeListener<AssetInfo> assetsListChangedListener = new ListChangeListener() {
		@Override
		public void elementAdded(Object source, int idx, Object elem) {
			TempSpriteManager.instance().reload();
		}

		@Override
		public void elementRemoved(Object source, int idx, Object elem) {
			TempSpriteManager.instance().reload();
		}
	};

	private final ChangeListener tempSpriteChangeListener = new ChangeListener() {
		@Override
		public void propertyChanged(Object source, String propertyName) {
			SpriteModel sprite = TempSpriteManager.instance().getTempSprite();
			if (sprite != null) {
				tempSpriteRdr = new SpriteRenderer(sprite);
			} else {
				tempSpriteRdr = null;
			}
		}
	};

	// -------------------------------------------------------------------------
	// Update
	// -------------------------------------------------------------------------

	public void update() {
		AppManager app = AppManager.instance();
		if (app.getInteractionMode() == AppManager.InteractionModes.ADD_SPRITES) {
			Vector2 p = st2w(Gdx.input.getX(), Gdx.input.getY());
			SpriteModel sprite = TempSpriteManager.instance().getTempSprite();
			if (sprite != null)
				sprite.setPosition(p.x - sprite.getWidth()/2, p.y - sprite.getHeight()/2);
		}
	}

	// -------------------------------------------------------------------------
	// Draw
	// -------------------------------------------------------------------------

	public void render(GL10 gl) {
		AppManager app = AppManager.instance();
		InteractionModes itMode = app.getInteractionMode();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (LayerRenderer rdr : layerRdrsMap.values())
			rdr.render(batch);
		if (itMode == InteractionModes.ADD_SPRITES && tempSpriteRdr != null)
			tempSpriteRdr.render(batch);
		batch.end();

		camera.apply(gl);
		if (itMode == InteractionModes.SELECT)
			bbDrawer.drawBoundingBoxes(gl);
		drawer.drawOriginAxis(2);
	}
}
