package aurelienribon.libgdx;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class VectorHelper {
	/**
	 * Rotates a vector aroung an origin.
	 * @param v The vector to rotate.
	 * @param o The origin.
	 * @param angleDeg The angle, in degrees.
	 */
	public static void rotate(Vector2 v, Vector2 o, float angleDeg) {
		float cos = MathUtils.cosDeg(angleDeg);
		float sin = MathUtils.sinDeg(angleDeg);
		float x = v.x;
		float y = v.y;
		v.x = cos*(x-o.x) - sin*(y-o.y) + o.x;
		v.y = sin*(x-o.x) + cos*(y-o.y) + o.y;
	}
}
