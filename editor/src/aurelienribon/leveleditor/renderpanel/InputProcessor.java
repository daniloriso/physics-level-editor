package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.AppManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class InputProcessor extends InputAdapter {
	private final MainRenderer rdr;
	private final Vector2 lastTouch = new Vector2();

	public InputProcessor(MainRenderer rdr) {
		this.rdr = rdr;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		lastTouch.set(x, y);
		return true;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		lastTouch.set(x, y);
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		if (Gdx.input.isButtonPressed(Buttons.RIGHT)) {
			Vector2 delta = rdr.sd2w(x - lastTouch.x, lastTouch.y - y);
			rdr.camera.position.add(-delta.x, -delta.y, 0);
			rdr.camera.update();
		}
		lastTouch.set(x, y);
		return true;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		rdr.camera.zoom *= amount > 0 ? 1.2f : 1/1.2f;
		rdr.camera.update();
		return true;
	}

	@Override
	public boolean keyDown(int keycode) {
		AppManager app = AppManager.instance();
		if (app.getInteractionMode() == AppManager.InteractionModes.ADD_SPRITES && keycode == Keys.TAB) {
			rdr.setTempSprite(isShiftPressed() ? rdr.getPreviousAsset() : rdr.getNextAsset());
		}
		return true;
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private boolean isShiftPressed() {
		return Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT);
	}
}
