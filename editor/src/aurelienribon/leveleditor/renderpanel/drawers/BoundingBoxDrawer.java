package aurelienribon.leveleditor.renderpanel.drawers;

import aurelienribon.leveleditor.models.behaviors.Measurable;
import aurelienribon.libgdx.Renderer2D;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class BoundingBoxDrawer {
	private final Vector2 vec = new Vector2();
	private final PrimitiveDrawer drawer;
	private final Renderer2D rdr;

	public BoundingBoxDrawer(Renderer2D rdr, PrimitiveDrawer drawer) {
		this.rdr = rdr;
		this.drawer = drawer;
	}

	public void drawBoundingBox(GL10 gl, Measurable m, Color color) {
		drawBoundingBox(gl, m, false, color);
	}

	public void drawBoundingBoxWithHandles(GL10 gl, Measurable m, Color color) {
		drawBoundingBox(gl, m, true, color);
	}

	private void drawBoundingBox(GL10 gl, Measurable m, boolean showHandles, Color color) {
		float x = m.getX();
		float y = m.getY();
		float w = m.getWidth();
		float h = m.getHeight();
		float angle = m.getRotation();
		boolean rotate = angle != 0;

		if (rotate) {
			gl.glPushMatrix();
			gl.glTranslatef(x+w/2, y+h/2, 0);
			gl.glRotatef(angle, 0, 0, 1);
			gl.glTranslatef(-x-w/2, -y-h/2, 0);
		}

		drawer.drawRect(vec.set(x, y), w, h, color, 2);

		if (showHandles) {
			float d = rdr.sd2w(10, 0).x;
			vec.sub(d/2, d/2);
			vec.add(0, 0); drawer.drawRect(vec, d, d, color, 2);
			vec.add(w/2, 0); drawer.drawRect(vec, d, d, color, 2);
			vec.add(w/2, 0); drawer.drawRect(vec, d, d, color, 2);
			vec.add(0, h/2); drawer.drawRect(vec, d, d, color, 2);
			vec.add(0, h/2); drawer.drawRect(vec, d, d, color, 2);
			vec.add(-w/2, 0); drawer.drawRect(vec, d, d, color, 2);
			vec.add(-w/2, 0); drawer.drawRect(vec, d, d, color, 2);
			vec.add(0, -h/2); drawer.drawRect(vec, d, d, color, 2);
		}

		if (rotate) {
			gl.glPopMatrix();
		}
	}
}
