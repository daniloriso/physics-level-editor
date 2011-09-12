package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.AssetsManager;
import aurelienribon.leveleditor.models.AssetInfo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
		Vector2 delta = rdr.sd2w(x - lastTouch.x, lastTouch.y - y);
		rdr.camera.position.add(-delta.x, -delta.y, 0);
		rdr.camera.update();
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
		if (keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT) {
			if (!AssetsManager.instance().isEmpty()) {
				AssetInfo info = AssetsManager.instance().get(0);
				Texture tex = new Texture(Gdx.files.absolute(info.getPath()));
				tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
				Sprite sp = new Sprite(tex);
				sp.setSize(info.getWidth() / 25f, info.getHeight() / 25f);
				rdr.setNextSprite(sp);
			}
		}
		return true;
	}
}
