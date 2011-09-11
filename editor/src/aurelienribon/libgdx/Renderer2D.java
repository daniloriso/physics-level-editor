package aurelienribon.libgdx;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Renderer2D {	
	public final Vector2 screenSizePixels = new Vector2();
	public final Vector2 screenSizeMeters = new Vector2();
	public final Vector2 pixelsPerMeter = new Vector2();
	public final Vector2 metersPerPixel = new Vector2();
	
	public final OrthographicCamera camera = new OrthographicCamera(0, 0);

	// -------------------------------------------------------------------------
	// Ctor
	// -------------------------------------------------------------------------
	
	public Renderer2D() {
		screenSizePixels.x = Gdx.graphics.getWidth();
		screenSizePixels.y = Gdx.graphics.getHeight();
		screenSizeMeters.set(1, 1);
		updateViewport();

		camera.position.set(0, 0, 0);
		camera.zoom = 1;
		camera.update();
	}

	// -------------------------------------------------------------------------
	// Viewport modification
	// -------------------------------------------------------------------------

	/**
	 * Sets the renderer viewport to display the specified world size when the
	 * camera zoom is at 1.
	 * @param metersX The word viewport width.
	 * @param metersY The world viewport height.
	 */
	public void setWorldViewport(float metersX, float metersY) {
		screenSizePixels.x = Gdx.graphics.getWidth();
		screenSizePixels.y = Gdx.graphics.getHeight();
		screenSizeMeters.set(metersX, metersY);
		updateViewport();
	}

	/**
	 * Changes the world viewport with a uniform pixels per meter ratio.
	 */
	public void setWorldViewportUniform() {
		screenSizePixels.x = Gdx.graphics.getWidth();
		screenSizePixels.y = Gdx.graphics.getHeight();
		float pxRatio = screenSizePixels.x / screenSizePixels.y;
		float mtRatio = screenSizeMeters.x / screenSizeMeters.y;

		if (pxRatio >= mtRatio) {
			screenSizeMeters.y = screenSizeMeters.x / pxRatio;
		} else {
			screenSizeMeters.x = screenSizeMeters.y * pxRatio;
		}

		updateViewport();
	}

	/**
	 * Changes the world viewport with a uniform pixels per meter ratio.
	 * Will try to fill the screen.
	 */
	public void setWorldViewportUniformToFill() {
		screenSizePixels.x = Gdx.graphics.getWidth();
		screenSizePixels.y = Gdx.graphics.getHeight();
		float pxRatio = screenSizePixels.x / screenSizePixels.y;
		float mtRatio = screenSizeMeters.x / screenSizeMeters.y;

		if (pxRatio >= mtRatio) {
			screenSizeMeters.x = screenSizeMeters.y * pxRatio;
		} else {
			screenSizeMeters.y = screenSizeMeters.x / pxRatio;
		}

		updateViewport();
	}

	private void updateViewport() {
		pixelsPerMeter.x = screenSizePixels.x / screenSizeMeters.x;
		pixelsPerMeter.y = screenSizePixels.y / screenSizeMeters.y;
		metersPerPixel.x = screenSizeMeters.x / screenSizePixels.x;
		metersPerPixel.y = screenSizeMeters.y / screenSizePixels.y;

		camera.viewportWidth = screenSizeMeters.x;
		camera.viewportHeight = screenSizeMeters.y;
		camera.update();
	}

	// -------------------------------------------------------------------------
	// Density independant conversions
	// -------------------------------------------------------------------------

	/**
	 * Converts a width into a density independant value.
	 */
	public static float dpX(float x) {
		boolean isLandscape = Gdx.graphics.getWidth() > Gdx.graphics.getHeight();
		return Gdx.app.getType() == ApplicationType.Android
			? x * Gdx.graphics.getPpiX() / 160
			: x * Gdx.graphics.getWidth() / (isLandscape ? 480 : 320);
	}

	/**
	 * Converts a height into a density independant value.
	 */
	public static float dpY(float y) {
		boolean isLandscape = Gdx.graphics.getWidth() > Gdx.graphics.getHeight();
		return Gdx.app.getType() == ApplicationType.Android
			? y * Gdx.graphics.getPpiY() / 160
			: y * Gdx.graphics.getHeight() / (isLandscape ? 320 : 480);
	}

	// -------------------------------------------------------------------------
	// Screen / World conversions
	// -------------------------------------------------------------------------

	private final Vector2 tmpVec1 = new Vector2();
	private final Vector2 tmpVec2 = new Vector2();
	private final Vector2 tmpVec3 = new Vector2();
	private final Vector2 tmpVec4 = new Vector2();

	/**
	 * Screen distance to world distance
	 */
	public final Vector2 sd2w(float dx, float dy) {
		tmpVec1.x = dx * metersPerPixel.x * camera.zoom;
		tmpVec1.y = dy * metersPerPixel.y * camera.zoom;

		return tmpVec1;
	}

	/**
	 * Screen position to world position
	 */
	public final Vector2 sp2w(float x, float y) {
		tmpVec2.x = x * metersPerPixel.x * camera.zoom;
		tmpVec2.y = y * metersPerPixel.y * camera.zoom;

		Vector3 p = camera.position;
		tmpVec2.x += p.x - screenSizeMeters.x / 2 * camera.zoom;
		tmpVec2.y += p.y - screenSizeMeters.y / 2 * camera.zoom;

		return tmpVec2;
	}

	/**
	 * Screen touch to world position
	 */
	public final Vector2 st2w(float x, float y) {
		tmpVec3.x = x * metersPerPixel.x * camera.zoom;
		tmpVec3.y = (Gdx.graphics.getHeight() - y) * metersPerPixel.y * camera.zoom;

		Vector3 p = camera.position;
		tmpVec3.x += p.x - screenSizeMeters.x / 2 * camera.zoom;
		tmpVec3.y += p.y - screenSizeMeters.y / 2 * camera.zoom;

		return tmpVec3;
	}

	/**
	 * World distance to screen distance
	 */
	public final Vector2 wd2s(float dx, float dy) {
		tmpVec4.x = dx * pixelsPerMeter.x / camera.zoom;
		tmpVec4.y = dy * pixelsPerMeter.y / camera.zoom;
		
		return tmpVec4;
	}
}
