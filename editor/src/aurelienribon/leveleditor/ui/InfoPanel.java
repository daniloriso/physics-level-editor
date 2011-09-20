package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.ui.infopanels.SelectModeDefaultInfoPanel;
import aurelienribon.leveleditor.ui.infopanels.SelectModeSpriteInfoPanel;
import aurelienribon.leveleditor.ui.infopanels.SpritesModeInfoPanel;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class InfoPanel extends JPanel {
	private InfoPanelChild currentChild;

	public InfoPanel() {
		super(new BorderLayout());
		add(new SelectModeDefaultInfoPanel(), BorderLayout.CENTER);

		AppManager.instance().addChangeListener(new ChangeListener() {
			@Override public void propertyChanged(Object source, String propertyName) {
				if (propertyName.equals("interactionMode")) {
					removeAll();
					if (currentChild != null)
						currentChild.dispose();
					switch (AppManager.instance().getInteractionMode()) {
						case SELECT: updateSelectModeInfoPanel(); break;
						case ADD_SPRITES: add(new SpritesModeInfoPanel(), BorderLayout.CENTER); break;
						default: assert false;
					}
					revalidate();
				}
			}
		});

		SelectionManager.instance().addChangeListener(new ChangeListener() {
			@Override public void propertyChanged(Object source, String propertyName) {
				if (propertyName.equals("selectedObject")) {
					if (AppManager.instance().getInteractionMode() == InteractionModes.SELECT)
						updateSelectModeInfoPanel();
				}
			}
		});
	}

	private void updateSelectModeInfoPanel() {
		removeAll();

		Object obj = SelectionManager.instance().getSelectedObject();

		if (obj == null) {
			add(new SelectModeDefaultInfoPanel(), BorderLayout.CENTER);
			revalidate();
			return;
		}

		if (obj instanceof SpriteModel) {
			SelectModeSpriteInfoPanel panel = new SelectModeSpriteInfoPanel();
			panel.setModel((Changeable)obj);
			add(panel, BorderLayout.CENTER);
		}

		revalidate();
	}
}
