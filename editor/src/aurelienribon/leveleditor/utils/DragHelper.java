package aurelienribon.leveleditor.utils;

import aurelienribon.leveleditor.models.behaviors.Measurable;
import aurelienribon.libgdx.VectorHelper;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class DragHelper {
	private static Vector2 v = new Vector2();
	private static Vector2 orig = new Vector2();

	/**
	 * The different clickable parts of an object.
	 */
	public enum DragActions {
		NONE, SHAPE,
		HANDLE_BL, HANDLE_BM, HANDLE_BR,
		HANDLE_TL, HANDLE_TM, HANDLE_TR,
		HANDLE_ML, HANDLE_MR
	}

	/**
	 * Returns true if the point p is over the object m. Takes into account
	 * the rotation of the object.
	 * @param m An object
	 * @param p A point
	 * @return
	 */
	public static boolean isOver(Measurable m, Vector2 p) {
		float x = m.getX();
		float y = m.getY();
		float w = m.getWidth();
		float h = m.getHeight();
		float r = m.getRotation();

		v.set(p);
		orig.set(x+w/2, y+h/2);

		if (r != 0)
			VectorHelper.rotate(v, orig, -r);

		return isInRect(v, x, y, w, h);
	}

	/**
	 * Gets the part of the object which is overed by the point p.
	 * @param m An object
	 * @param p A point
	 * @param handleSize The dimention of the resize handles
	 * @return
	 */
	public static DragActions getAction(Measurable m, Vector2 p, Vector2 handleSize) {
		float x = m.getX();
		float y = m.getY();
		float w = m.getWidth();
		float h = m.getHeight();
		float r = m.getRotation();
		float hw = handleSize.x;
		float hh = handleSize.y;

		v.set(p);
		orig.set(x+w/2, y+h/2);

		if (r != 0)
			VectorHelper.rotate(v, orig, -r);

		if (isInRect(v, x-hw/2, y-hh/2, hw, hh))
			return DragActions.HANDLE_BL;
		if (isInRect(v, x+w/2-hw/2, y-hh/2, hw, hh))
			return DragActions.HANDLE_BM;
		if (isInRect(v, x+w-hw/2, y-hh/2, hw, hh))
			return DragActions.HANDLE_BR;
		if (isInRect(v, x-hw/2, y+h-hh/2, hw, hh))
			return DragActions.HANDLE_TL;
		if (isInRect(v, x+w/2-hw/2, y+h-hh/2, hw, hh))
			return DragActions.HANDLE_TM;
		if (isInRect(v, x+w-hw/2, y+h-hh/2, hw, hh))
			return DragActions.HANDLE_TR;
		if (isInRect(v, x-hw/2, y+h/2-hh/2, hw, hh))
			return DragActions.HANDLE_ML;
		if (isInRect(v, x+w-hw/2, y+h/2-hh/2, hw, hh))
			return DragActions.HANDLE_MR;
		if (isInRect(v, x, y, w, h))
			return DragActions.SHAPE;

		return DragActions.NONE;
	}

	private static boolean isInRect(Vector2 p, float x, float y, float w, float h) {
		return x <= p.x && p.x <= x+w && y <= p.y && p.y <= y+h;
	}
}
