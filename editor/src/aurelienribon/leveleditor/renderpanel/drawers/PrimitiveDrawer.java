package aurelienribon.leveleditor.renderpanel.drawers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.glutils.ImmediateModeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class PrimitiveDrawer {
	private final ImmediateModeRenderer imr = new ImmediateModeRenderer();
	private final Vector2 vec1 = new Vector2();
	private final Vector2 vec2 = new Vector2();

	public void drawLine(Vector2 p1, Vector2 p2, Color c, float lineWidth) {
		Gdx.gl10.glLineWidth(lineWidth);
		imr.begin(GL10.GL_LINES);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p1.x, p1.y, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p2.x, p2.y, 0);
		imr.end();
	}

	public void drawRect(Vector2 p, float w, float h, Color c, float lineWidth) {
		Gdx.gl10.glLineWidth(lineWidth);
		imr.begin(GL10.GL_LINE_LOOP);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x, p.y, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x, p.y+h, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x+w, p.y+h, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x+w, p.y, 0);
		imr.end();
	}

	public void fillRect(Vector2 p, float w, float h, Color c) {
		imr.begin(GL10.GL_TRIANGLE_FAN);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x, p.y, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x, p.y+h, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x+w, p.y+h, 0);
		imr.color(c.r, c.g, c.b, c.a); imr.vertex(p.x+w, p.y, 0);
		imr.end();
	}

	public void drawOriginAxis(float lineWidth) {
		drawLine(vec1.set(0, 0), vec2.set(1, 0), Color.RED, lineWidth);
		drawLine(vec1.set(0, 0), vec2.set(0, 1), Color.GREEN, lineWidth);
	}
}
