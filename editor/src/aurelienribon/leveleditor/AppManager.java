package aurelienribon.leveleditor;

import aurelienribon.leveleditor.renderpanel.RenderPanel;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import java.util.ArrayList;
import java.util.List;

public class AppManager implements Changeable {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final AppManager instance = new AppManager();
	public static AppManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// RenderPanel
	// -------------------------------------------------------------------------

	private final RenderPanel renderPanel = new RenderPanel();

	public RenderPanel getRenderPanel() {
		return renderPanel;
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

	// -------------------------------------------------------------------------
	// Changeable impl.
	// -------------------------------------------------------------------------

	private final List<ChangeListener> changeListeners = new ArrayList<ChangeListener>(3);

	@Override
	public void addChangeListener(ChangeListener l) {
		changeListeners.add(l);
	}

	@Override
	public void removeChangeListener(ChangeListener l) {
		changeListeners.add(l);
	}

	private void firePropertyChanged(String propertyName) {
		for (ChangeListener listener : changeListeners)
			listener.propertyChanged(this, propertyName);
	}
}
