package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.AssetsManager;
import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.libgdx.Renderer2D;
import aurelienribon.libgdx.TextWriter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
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
	private Sprite nextSprite;

	public MainRenderer() {
		setWorldViewport(10, 10);
		setWorldViewportUniformToFill();
		writer.setColor(Color.BLACK);
	}

	public void setNextSprite(Sprite sp) {
		this.nextSprite = sp;
	}

	// -------------------------------------------------------------------------
	// Update
	// -------------------------------------------------------------------------

	public void update() {
		if (nextSprite != null) {
			Vector2 p = sp2w(Gdx.input.getX(), screenSizePixels.y - Gdx.input.getY());
			nextSprite.setPosition(
				p.x - nextSprite.getWidth()/2,
				p.y - nextSprite.getHeight()/2);
		}
	}

	// -------------------------------------------------------------------------
	// Draw
	// -------------------------------------------------------------------------

	public void render(GL10 gl) {
		camera.apply(gl);
		drawLine(vec1.set(0, 0), vec2.set(1, 0), Color.RED, 2);
		drawLine(vec1.set(0, 0), vec2.set(0, 1), Color.GREEN, 2);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if (isShiftPressed() && nextSprite != null)
			nextSprite.draw(batch);
		batch.end();

		String workingLayerName = LayersManager.instance().getWorkingLayer() != null
			? "<" + LayersManager.instance().getWorkingLayer().getName() + ">"
			: "<please select a layer>";

		batch.getProjectionMatrix().setToOrtho2D(0, 0, screenSizePixels.x, screenSizePixels.y);
		batch.begin();
		writer.print("Selected layer: ");
		writer.printLn(workingLayerName, Color.BLUE);
		writer.reset();
		batch.end();
	}

	// -------------------------------------------------------------------------
	// Basic drawing
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
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x - w/2, p.y - h/2, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x - w/2, p.y + h/2, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x + w/2, p.y + h/2, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x + w/2, p.y - h/2, 0);
		imr.end();
	}

	private void fillRect(Vector2 p, float w, float h, Color c) {
		imr.begin(GL10.GL_TRIANGLE_FAN);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x - w/2, p.y - h/2, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x - w/2, p.y + h/2, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x + w/2, p.y + h/2, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x + w/2, p.y - h/2, 0);
		imr.end();
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private boolean isShiftPressed() {
		return Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) ||
			Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT);
	}
}
