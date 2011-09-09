package aurelienribon.leveleditor;

import aurelienribon.leveleditor.renderpanel.RenderPanel;

public class AppManager {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final AppManager instance = new AppManager();
	public static AppManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Content
	// -------------------------------------------------------------------------

	private final RenderPanel renderPanel = new RenderPanel();

	public RenderPanel getRenderPanel() {
		return renderPanel;
	}
}
