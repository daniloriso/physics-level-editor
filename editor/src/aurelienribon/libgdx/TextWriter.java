package aurelienribon.libgdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class TextWriter {
	private final Renderer2D rdr;
	private final SpriteBatch batch;
	private final BitmapFont font;
	private float w = 5;
	private float h = 0;

	public TextWriter(Renderer2D rdr, SpriteBatch batch, BitmapFont font) {
		this.rdr = rdr;
		this.batch = batch;
		this.font = font;
	}

	public void print(String txt) {
		font.draw(batch, txt, w, rdr.screenSizePixels.y - h);
		w += font.getBounds(txt).width;
	}

	public void print(String txt, Color color) {
		Color tmp = font.getColor();
		font.setColor(color);
		font.draw(batch, txt, w, rdr.screenSizePixels.y - h);
		font.setColor(tmp);
		w += font.getBounds(txt).width;
	}

	public void printLn(String txt) {
		font.draw(batch, txt, w, rdr.screenSizePixels.y - h);
		w = 5;
		h += font.getLineHeight();
	}

	public void printLn(String txt, Color color) {
		Color tmp = font.getColor();
		font.setColor(color);
		font.draw(batch, txt, w, rdr.screenSizePixels.y - h);
		font.setColor(tmp);
		w = 5;
		h += font.getLineHeight();
	}

	public void reset() {
		w = 5;
		h = 0;
	}

	public void setColor(Color color) {
		font.setColor(color);
	}

	public float stringWidth(String txt) {
		return font.getBounds(txt).width;
	}
}
