package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AssetsManager;
import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.leveleditor.utils.AssetLoader;
import aurelienribon.libgdx.Renderer2D;
import aurelienribon.libgdx.TextWriter;
import aurelienribon.utils.ObservableList.ListChangedListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class MainRenderer extends Renderer2D {
	private final SpriteBatch batch = new SpriteBatch();
	private final TextWriter writer = new TextWriter(this, batch, new BitmapFont());
	private final ImmediateModeRenderer imr = new ImmediateModeRenderer();
	private final Vector2 vec1 = new Vector2();
	private final Vector2 vec2 = new Vector2();
	private Sprite tempSprite;
	private AssetInfo tempAsset;

	public MainRenderer() {
		setWorldViewport(20, 20);
		setWorldViewportUniformToFill();
		writer.setColor(Color.BLACK);

		AssetsManager.instance().addListChangedListener(new ListChangedListener() {
			@Override public void elementAdded(Object source, int idx, Object elem) {
				if (tempSprite == null)
					setTempSprite(getNextAsset());
			}

			@Override public void elementRemoved(Object source, int idx, Object elem) {
				setTempSprite(tempAsset);
			}
		});
	}

	public AssetInfo getNextAsset() {
		AssetsManager am = AssetsManager.instance();
		if (!am.isEmpty()) {
			int id = am.indexOf(tempAsset);
			return am.get((id+1) % am.size());
		}
		return null;
	}

	public AssetInfo getPreviousAsset() {
		AssetsManager am = AssetsManager.instance();
		if (!am.isEmpty()) {
			int id = am.indexOf(tempAsset);
			return am.get((id-1) % am.size());
		}
		return null;
	}

	public void setTempSprite(AssetInfo asset) {
		if (asset == null) {
			tempSprite = null;
			tempAsset = null;
			return;
		}
		
		AssetsManager am = AssetsManager.instance();
		if (am.indexOf(asset) >= 0) {
			tempSprite = new Sprite(AssetLoader.getAssetTexture(asset));
			tempSprite.setSize(asset.getWidth()/50f, asset.getHeight()/50f);
			tempAsset = asset;
		} else {
			setTempSprite(getNextAsset());
		}
	}

	// -------------------------------------------------------------------------
	// Update
	// -------------------------------------------------------------------------

	public void update() {
		if (tempSprite != null) {
			Vector2 p = sp2w(Gdx.input.getX(), screenSizePixels.y - Gdx.input.getY());
			tempSprite.setPosition(
				p.x - tempSprite.getWidth()/2,
				p.y - tempSprite.getHeight()/2);
		}
	}

	// -------------------------------------------------------------------------
	// Draw
	// -------------------------------------------------------------------------

	public void render(GL10 gl) {
		AppManager app = AppManager.instance();

		camera.apply(gl);
		drawLine(vec1.set(0, 0), vec2.set(1, 0), Color.RED, 2);
		drawLine(vec1.set(0, 0), vec2.set(0, 1), Color.GREEN, 2);

		switch (app.getInteractionMode()) {
			case SELECT:
				break;

			case ADD_SPRITES:
				batch.setProjectionMatrix(camera.combined);
				batch.begin();
				if (tempSprite != null)
					tempSprite.draw(batch);
				batch.end();
				break;

			default: assert false;
		}
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
