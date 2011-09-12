package aurelienribon.leveleditor.renderpanel.modelrenderers;

import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.utils.ChangeListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SpriteRenderer implements LayerChildRenderer {
	private final SpriteModel model;
	private final Sprite sprite;

	public SpriteRenderer(SpriteModel model) {
		this.model = model;
		model.addChangeListener(modelChangeListener);

		Texture tex = new Texture(Gdx.files.absolute(model.getAsset().getPath()));
		this.sprite = new Sprite(tex);
		update();
	}

	private void update() {
		sprite.setPosition(model.getX(), model.getY());
		sprite.setSize(model.getWidth(), model.getHeight());
		sprite.setRotation(model.getRotation());
	}

	private final ChangeListener modelChangeListener = new ChangeListener() {
		@Override public void propertyChanged(Object source, String propertyName) {
			update();
		}
	};

	// -------------------------------------------------------------------------
	// LayerChildRenderer impl.
	// -------------------------------------------------------------------------

	@Override
	public void render(SpriteBatch batch) {
		sprite.draw(batch);
	}
}
