package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.AssetsManager;
import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.TempSpriteManager;
import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.models.behaviors.Delimitable;
import aurelienribon.leveleditor.models.behaviors.Resizable;
import aurelienribon.leveleditor.renderpanel.modelrenderers.LayerRenderer;
import aurelienribon.leveleditor.renderpanel.modelrenderers.SpriteRenderer;
import aurelienribon.libgdx.Renderer2D;
import aurelienribon.libgdx.TextWriter;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.ObservableList.ListChangedListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer;
import com.badlogic.gdx.math.Vector2;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class MainRenderer extends Renderer2D {
	private final SpriteBatch batch = new SpriteBatch();
	private final TextWriter writer = new TextWriter(this, batch, new BitmapFont());
	private final ImmediateModeRenderer imr = new ImmediateModeRenderer();
	private final Map<LayerModel, LayerRenderer> layerRdrsMap = new LinkedHashMap<LayerModel, LayerRenderer>();
	private SpriteRenderer tempSpriteRdr;
	
	private final Vector2 vec1 = new Vector2();
	private final Vector2 vec2 = new Vector2();

	public MainRenderer() {
		setWorldViewport(20, 20);
		setWorldViewportUniformToFill();
		writer.setColor(Color.BLACK);

		for (LayerModel layer : LayersManager.instance().getAll())
			layerRdrsMap.put(layer, new LayerRenderer(layer));
			
		LayersManager.instance().addListChangedListener(layersListChangedListener);
		AssetsManager.instance().addListChangedListener(assetsListChangedListener);
		TempSpriteManager.instance().addChangeListener(tempSpriteChangeListener);
	}

	private final ListChangedListener<LayerModel> layersListChangedListener = new ListChangedListener() {
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

	private final ListChangedListener<AssetInfo> assetsListChangedListener = new ListChangedListener() {
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
		InteractionModes mode = app.getInteractionMode();

		camera.apply(gl);
		drawLine(vec1.set(0, 0), vec2.set(1, 0), Color.RED, 2);
		drawLine(vec1.set(0, 0), vec2.set(0, 1), Color.GREEN, 2);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for (LayerRenderer rdr : layerRdrsMap.values())
			rdr.render(batch);
		if (mode == InteractionModes.ADD_SPRITES && tempSpriteRdr != null)
			tempSpriteRdr.render(batch);
		batch.end();

		drawBoundingBoxes(gl);
	}

	private void drawBoundingBoxes(GL10 gl) {
		if (AppManager.instance().getInteractionMode() != InteractionModes.SELECT)
			return;

		camera.apply(gl);
		gl.glEnable(GL10.GL_BLEND);

		List<Object> selObjs = SelectionManager.instance().getSelectedObjects();
		Object moverObj = SelectionManager.instance().getMouseOverObject();

		for (Object sO : selObjs) {
			if (sO instanceof Delimitable && sO instanceof Resizable) {
				drawBoundingBoxWithHandles((Delimitable)sO, Theme.SELECTED_BOUNDINGBOX_COLOR);
			} else {
				drawBoundingBox((Delimitable)sO, Theme.SELECTED_BOUNDINGBOX_COLOR);
			}
		}
		if (!selObjs.contains(moverObj) && moverObj instanceof Delimitable)
			drawBoundingBox((Delimitable)moverObj, Theme.MOUSEOVER_BOUNDINGBOX_COLOR);
	}

	private void drawBoundingBox(Delimitable e, Color color) {
		if (e == null)
			return;
		vec1.set(e.getX(), e.getY());
		drawRect(vec1, e.getWidth(), e.getHeight(), color, 3);
	}

	private void drawBoundingBoxWithHandles(Delimitable e, Color color) {
		if (e == null)
			return;
		float w = e.getWidth();
		float h = e.getHeight();
		float d = sd2w(10, 0).x;

		vec1.set(e.getX(), e.getY());
		drawRect(vec1, w, h, color, 3);

		vec1.sub(d/2, d/2);
		vec1.add(0, 0); drawRect(vec1, d, d, color, 3);
		vec1.add(w/2, 0); drawRect(vec1, d, d, color, 3);
		vec1.add(w/2, 0); drawRect(vec1, d, d, color, 3);
		vec1.add(0, h/2); drawRect(vec1, d, d, color, 3);
		vec1.add(0, h/2); drawRect(vec1, d, d, color, 3);
		vec1.add(-w/2, 0); drawRect(vec1, d, d, color, 3);
		vec1.add(-w/2, 0); drawRect(vec1, d, d, color, 3);
		vec1.add(0, -h/2); drawRect(vec1, d, d, color, 3);
	}

	// -------------------------------------------------------------------------
	// Primitives
	// -------------------------------------------------------------------------

	private void drawLine(Vector2 p1, Vector2 p2, Color c, float lineWidth) {
		Gdx.gl10.glLineWidth(lineWidth);
		imr.begin(GL10.GL_LINES);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p1.x, p1.y, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p2.x, p2.y, 0);
		imr.end();
	}

	private void drawRect(Vector2 p, float w, float h, Color c, float lineWidth) {
		Gdx.gl10.glLineWidth(lineWidth);
		imr.begin(GL10.GL_LINE_LOOP);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x, p.y, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x, p.y+h, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x+w, p.y+h, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x+w, p.y, 0);
		imr.end();
	}

	private void fillRect(Vector2 p, float w, float h, Color c) {
		imr.begin(GL10.GL_TRIANGLE_FAN);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x, p.y, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x, p.y+h, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x+w, p.y+h, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x+w, p.y, 0);
		imr.end();
	}
}
