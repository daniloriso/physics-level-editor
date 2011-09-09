package aurelienribon.leveleditor.renderpanel;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

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
		gl.glClearColor(0.90f, 0.90f, 0.90f, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height) {
		Gdx.gl.glViewport(0, 0, width, height);
		renderer.camera.viewportWidth = width;
		renderer.camera.viewportHeight = height;
		renderer.camera.update();
	}

	@Override
	public void resume() {
	}

	@Override
	public void pause() {
	}
}
