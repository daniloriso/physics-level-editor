package aurelienribon.leveleditor.renderpanel.drawers;

import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.models.behaviors.Measurable;
import aurelienribon.leveleditor.renderpanel.Theme;
import aurelienribon.libgdx.Renderer2D;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;
import java.util.List;

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

	public void drawBoundingBoxes(GL10 gl) {
		gl.glEnable(GL10.GL_BLEND);

		List<Object> selObjs = SelectionManager.instance().getSelectedObjects();
		Object moverObj = SelectionManager.instance().getMouseOverObject();

		if (SelectionManager.instance().areSelectedObjectsSameType())
			for (Object obj : selObjs)
				if (obj instanceof Measurable)
					drawBoundingBox(gl, (Measurable)obj, true, Theme.SELECTED_BOUNDINGBOX_COLOR);

		if (!selObjs.contains(moverObj) && moverObj instanceof Measurable)
			drawBoundingBox(gl, (Measurable)moverObj, false, Theme.MOUSEOVER_BOUNDINGBOX_COLOR);
	}

	private void drawBoundingBox(GL10 gl, Measurable e, boolean showHandles, Color color) {
		float x = e.getX();
		float y = e.getY();
		float w = e.getWidth();
		float h = e.getHeight();
		float angle = ((Measurable)e).getRotation();
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
