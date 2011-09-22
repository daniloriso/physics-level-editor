package aurelienribon.leveleditor.renderpanel;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.TempSpriteManager;
import aurelienribon.leveleditor.models.LayerChild;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.behaviors.Measurable;
import aurelienribon.leveleditor.utils.DragHelper;
import aurelienribon.leveleditor.utils.DragHelper.DragActions;
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
						Object obj = SelectionManager.instance().getMouseOverObject();
						SelectionManager.instance().addSelectedObject(obj);

					} else {
						Vector2 p = rdr.st2w(x, y);
						List<Object> objs = SelectionManager.instance().getSelectedObjects();

						for (Object obj : objs) {
							if (obj instanceof Measurable) {
								dragAction = DragHelper.getAction((Measurable)obj, p, rdr.sd2w(10, 10));
								if (dragAction != DragActions.NONE)
									break;
							}
						}

						if (dragAction == DragActions.NONE) {
							Object obj = SelectionManager.instance().getMouseOverObject();
							SelectionManager.instance().setSelectedObject(obj);
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
			List<Object> objs = SelectionManager.instance().getSelectedObjects();
			float dx = delta.x;
			float dy = delta.y;

			for (Object obj : objs) {
				if (obj instanceof Measurable) {
					Measurable m = (Measurable)obj;
					float mx = m.getX();
					float my = m.getY();
					float mw = m.getWidth();
					float mh = m.getHeight();

					switch (dragAction) {
						case SHAPE:
							m.setPosition(mx + dx, my + dy);
							break;

						case HANDLE_BL:
							dy = dx / (mw/mh);
							m.setSize(mw - dx, mh - dy);
							m.setPosition(mx + dx, my + dy);
							break;

						case HANDLE_BM:
							m.setSize(mw, mh - dy);
							m.setPosition(mx, my + dy);
							break;

						case HANDLE_BR:
							dy = -dx / (mw/mh);
							m.setSize(mw + dx, mh - dy);
							m.setPosition(mx, my + dy);
							break;

						case HANDLE_TL:
							dy = -dx / (mw/mh);
							m.setSize(mw - dx, mh + dy);
							m.setPosition(mx + dx, my);
							break;

						case HANDLE_TM:
							m.setSize(mw, mh + dy);
							break;

						case HANDLE_TR:
							dy = dx / (mw/mh);
							m.setSize(mw + dx, mh + dy);
							break;

						case HANDLE_ML:
							m.setSize(mw - dx, mh);
							m.setPosition(mx + dx, my);
							break;

						case HANDLE_MR:
							m.setSize(mw + dx, mh);
							break;
					}
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
					SelectionManager.instance().setMouseOverObject(pickLayerChild(layer, p));
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

	private Measurable pickLayerChild(LayerModel layer, Vector2 p) {
		for (int i=layer.size()-1; i>=0; i--) {
			LayerChild child = layer.get(i);
			if (child instanceof Measurable && DragHelper.isOver((Measurable)child, p))
				return (Measurable)child;
		}
		return null;
	}
}
