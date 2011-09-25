package aurelienribon.leveleditor.renderpanel.modelrenderers;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.renderpanel.MainRenderer;
import aurelienribon.leveleditor.utils.AssetLoader;
import aurelienribon.utils.ChangeListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SpriteRenderer {
	private final MainRenderer rdr;
	private final SpriteModel model;
	private final Sprite sprite;

	public SpriteRenderer(MainRenderer rdr, SpriteModel model) {
		this.rdr = rdr;
		this.model = model;
		this.sprite = new Sprite(AssetLoader.getAssetTexture(model.getAsset()));
		model.addChangeListener(modelChangeListener);
		update();
	}

	private void update() {
		sprite.setPosition(model.getX(), model.getY());
		sprite.setSize(model.getWidth(), model.getHeight());
		sprite.setRotation(model.getRotation());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
	}

	private final ChangeListener modelChangeListener = new ChangeListener() {
		@Override public void propertyChanged(Object source, String propertyName) {
			update();
		}
	};

	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}

	public void renderOverlay(GL10 gl) {
		if (model.isSelected()) {
			rdr.getBoundingBoxDrawer().drawBoundingBoxWithHandles(gl, model, Color.RED);
		} else if (SelectionManager.instance().getMouseOverSprite() == model) {
			rdr.getBoundingBoxDrawer().drawBoundingBox(gl, model, Color.RED);
		}
	}
}
