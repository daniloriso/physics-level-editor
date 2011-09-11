package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.LayersManager;
import aurelienribon.libgdx.Renderer2D;
import aurelienribon.libgdx.TextWriter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class Renderer extends Renderer2D {
	private final SpriteBatch batch = new SpriteBatch();
	private final TextWriter writer = new TextWriter(this, batch, new BitmapFont());

	public Renderer() {
		writer.setColor(Color.BLACK);
	}

	public void render() {
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
}
