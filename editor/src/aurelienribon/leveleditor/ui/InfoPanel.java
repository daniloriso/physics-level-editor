package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.ui.infopanels.SelectModeDefaultInfoPanel;
import aurelienribon.leveleditor.ui.infopanels.SelectModeSpriteInfoPanel;
import aurelienribon.leveleditor.ui.infopanels.SpritesModeInfoPanel;
import aurelienribon.utils.ChangeListener;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class InfoPanel extends JPanel {
	private final InfoPanelChild selectModeDefaultInfoPanel = new SelectModeDefaultInfoPanel();
	private final InfoPanelChild selectModeSpriteInfoPanel = new SelectModeSpriteInfoPanel();
	private final InfoPanelChild spritesModeInfoPanel = new SpritesModeInfoPanel();
	private InfoPanelChild currentPanel;

	public InfoPanel() {
		super(new BorderLayout());
		setBackground(Theme.MAIN_ALT_BACKGROUND);
		setPanel(selectModeDefaultInfoPanel);

		AppManager.instance().addChangeListener(new ChangeListener() {
			@Override public void propertyChanged(Object source, String propertyName) {
				if (propertyName.equals("interactionMode")) {
					switch (AppManager.instance().getInteractionMode()) {
						case SELECT: updateSelectModeInfoPanel(); break;
						case ADD_SPRITES: setPanel(spritesModeInfoPanel); break;
						default: assert false;
					}
				}
			}
		});

		SelectionManager.instance().addChangeListener(new ChangeListener() {
			@Override public void propertyChanged(Object source, String propertyName) {
				if (propertyName.equals("selectedObjects")) {
					if (AppManager.instance().getInteractionMode() == InteractionModes.SELECT)
						updateSelectModeInfoPanel();
				}
			}
		});
	}

	private void setPanel(InfoPanelChild panel) {
		if (currentPanel != null)
			currentPanel.setModels(null);
		currentPanel = panel;
		currentPanel.setModels(SelectionManager.instance().getSelectedObjects());
		removeAll();
		add(currentPanel, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	private void updateSelectModeInfoPanel() {
		List<Object> objs = SelectionManager.instance().getSelectedObjects();
		if (getObjectsType(objs) == SpriteModel.class) {
			setPanel(selectModeSpriteInfoPanel);
		} else {
			setPanel(selectModeDefaultInfoPanel);
		}
	}

	private Class getObjectsType(List<Object> objs) {
		if (objs.isEmpty())
			return null;
		Class ret = objs.get(0).getClass();
		for (Object obj : objs)
			if (obj.getClass() != ret)
				return null;
		return ret;
	}
}
