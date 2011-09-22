package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.TempSpriteManager;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.models.behaviors.Measurable;
import aurelienribon.leveleditor.utils.DragHelper;
import aurelienribon.leveleditor.utils.DragHelper.DragActions;
import aurelienribon.utils.ObservableList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class InputProcessor extends InputAdapter {
	private final MainRenderer rdr;
	private final Vector2 lastTouch = new Vector2();
	private DragActions dragAction = DragActions.NONE;

	public InputProcessor(MainRenderer rdr) {
		this.rdr = rdr;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		dragAction = DragActions.NONE;
		if (button == Buttons.LEFT) {
			AppManager app = AppManager.instance();
			switch (app.getInteractionMode()) {
				case ADD_SPRITES:
					TempSpriteManager.instance().addSpriteToWorkingLayer();
					break;

				case SELECT:
					if (isCtrlPressed()) {
						SpriteModel sprite = SelectionManager.instance().getMouseOverSprite();
						SelectionManager.instance().select(sprite, false);

					} else {
						Vector2 p = rdr.st2w(x, y);
						List<SpriteModel> sprites = SelectionManager.instance().getSelectedSprites();

						for (SpriteModel sprite : sprites) {
							dragAction = DragHelper.getAction(sprite, p, rdr.sd2w(10, 10));
							if (dragAction != DragActions.NONE)
								break;
						}

						if (dragAction == DragActions.NONE) {
							SpriteModel sprite = SelectionManager.instance().getMouseOverSprite();
							SelectionManager.instance().select(sprite, true);
						}
					}
					break;

				default: assert false;
			}
		}

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

		} else if (Gdx.input.isButtonPressed(Buttons.LEFT)) {
			Vector2 delta = rdr.sd2w(x - lastTouch.x, lastTouch.y - y);
			List<SpriteModel> sprites = SelectionManager.instance().getSelectedSprites();
			float dx = delta.x;
			float dy = delta.y;

			for (SpriteModel sp : sprites) {
				float spX = sp.getX();
				float spY = sp.getY();
				float spW = sp.getWidth();
				float spH = sp.getHeight();

				switch (dragAction) {
					case SHAPE:
						sp.setPosition(spX + dx, spY + dy);
						break;

					case HANDLE_BL:
						dy = dx / (spW/spH);
						sp.setSize(spW - dx, spH - dy);
						sp.setPosition(spX + dx, spY + dy);
						break;

					case HANDLE_BM:
						sp.setSize(spW, spH - dy);
						sp.setPosition(spX, spY + dy);
						break;

					case HANDLE_BR:
						dy = -dx / (spW/spH);
						sp.setSize(spW + dx, spH - dy);
						sp.setPosition(spX, spY + dy);
						break;

					case HANDLE_TL:
						dy = -dx / (spW/spH);
						sp.setSize(spW - dx, spH + dy);
						sp.setPosition(spX + dx, spY);
						break;

					case HANDLE_TM:
						sp.setSize(spW, spH + dy);
						break;

					case HANDLE_TR:
						dy = dx / (spW/spH);
						sp.setSize(spW + dx, spH + dy);
						break;

					case HANDLE_ML:
						sp.setSize(spW - dx, spH);
						sp.setPosition(spX + dx, spY);
						break;

					case HANDLE_MR:
						sp.setSize(spW + dx, spH);
						break;
				}
			}
		}

		lastTouch.set(x, y);
		return true;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		AppManager app = AppManager.instance();
		switch (app.getInteractionMode()) {
			case SELECT:
				LayerModel layer = LayersManager.instance().getWorkingLayer();
				if (layer != null) {
					Vector2 p = rdr.st2w(x, y);
					SelectionManager.instance().setMouseOverSprite(pickSprite(layer, p));
				}
				break;
		}
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
			if (isShiftPressed()) {
				TempSpriteManager.instance().previous();
			} else {
				TempSpriteManager.instance().next();
			}
		}
		return true;
	}

	// -------------------------------------------------------------------------
	// Helpers
	// -------------------------------------------------------------------------

	private boolean isShiftPressed() {
		return Gdx.input.isKeyPressed(Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Keys.SHIFT_RIGHT);
	}

	private boolean isCtrlPressed() {
		return Gdx.input.isKeyPressed(Keys.CONTROL_LEFT) || Gdx.input.isKeyPressed(Keys.CONTROL_RIGHT);
	}

	private SpriteModel pickSprite(LayerModel layer, Vector2 p) {
		ObservableList<SpriteModel> sprites = layer.getSprites();
		for (int i=sprites.size()-1; i>=0; i--) {
			SpriteModel sprite = sprites.get(i);
			if (DragHelper.isOver(sprite, p))
				return sprite;
		}
		return null;
	}
}
