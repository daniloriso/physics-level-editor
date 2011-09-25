package aurelienribon.leveleditor.renderpanel;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class RenderPanel implements ApplicationListener {
	private MainRenderer renderer;

	@Override public void create() {
		this.renderer = new MainRenderer();
		Gdx.input.setInputProcessor(new InputProcessor(renderer));

		GL10 gl = Gdx.gl10;
		gl.glClearColor(1,1,1,1);
		gl.glEnable(GL10.GL_BLEND);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		renderer.update();
		GL10 gl = Gdx.gl10;
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		renderer.render(gl);
	}

	@Override
	public void resize(int width, int height) {
		Gdx.gl.glViewport(0, 0, width, height);
		renderer.setWorldViewportUniform();
	}

	@Override
	public void resume() {
	}

	@Override
	public void pause() {
	}
}
