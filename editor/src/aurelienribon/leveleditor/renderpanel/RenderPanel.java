package aurelienribon.leveleditor.renderpanel;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class RenderPanel implements ApplicationListener {
	private Renderer renderer;

	@Override public void create() {
		this.renderer = new Renderer();
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		GL10 gl = Gdx.gl10;
		gl.glClearColor(0.95f, 0.95f, 0.95f, 1);
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
