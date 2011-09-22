package aurelienribon.leveleditor;

import aurelienribon.leveleditor.renderpanel.RenderPanel;
import aurelienribon.utils.ChangeableObject;
import java.awt.Component;

public class AppManager extends ChangeableObject {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final AppManager instance = new AppManager();
	public static AppManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Components
	// -------------------------------------------------------------------------

	private final RenderPanel renderPanel = new RenderPanel();
	private Component renderCanvas;

	public RenderPanel getRenderPanel() {
		return renderPanel;
	}

	public Component getRenderCanvas() {
		return renderCanvas;
	}

	public void setRenderCanvas(Component renderCanvas) {
		this.renderCanvas = renderCanvas;
		firePropertyChanged("renderCanvas");
	}

	// -------------------------------------------------------------------------
	// Modes
	// -------------------------------------------------------------------------

	public enum InteractionModes {SELECT, ADD_SPRITES}
	
	private InteractionModes interactionMode = InteractionModes.SELECT;

	public InteractionModes getInteractionMode() {
		return interactionMode;
	}

	public void setInteractionMode(InteractionModes interactionMode) {
		this.interactionMode = interactionMode;
		firePropertyChanged("interactionMode");
	}
}
