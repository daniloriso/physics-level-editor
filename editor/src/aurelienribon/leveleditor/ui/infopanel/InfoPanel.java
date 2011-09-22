package aurelienribon.leveleditor.ui.infopanel;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.ui.Theme;
import aurelienribon.utils.ChangeListener;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class InfoPanel extends JPanel {
	private final Map<String, InfoPanelChild> panelsMap = new HashMap<String, InfoPanelChild>();
	private InfoPanelChild currentPanel;

	public InfoPanel() {
		super(new CardLayout());
		panelsMap.put("SELECT_DEFAULT", new SelectModeDefaultInfoPanel());
		panelsMap.put("SELECT_SPRITES", new SelectModeSpriteInfoPanel());
		panelsMap.put("ADDSPRITES", new AddSpritesModeInfoPanel());
		add(panelsMap.get("SELECT_DEFAULT"), "SELECT_DEFAULT");
		add(panelsMap.get("SELECT_SPRITES"), "SELECT_SPRITES");
		add(panelsMap.get("ADDSPRITES"), "ADDSPRITES");

		setBackground(Theme.MAIN_ALT_BACKGROUND);
		setPanel("SELECT_DEFAULT");

		AppManager.instance().addChangeListener(new ChangeListener() {
			@Override public void propertyChanged(Object source, String propertyName) {
				if (propertyName.equals("interactionMode")) {
					switch (AppManager.instance().getInteractionMode()) {
						case SELECT: updateSelectModeInfoPanel(); break;
						case ADD_SPRITES: setPanel("ADDSPRITES"); break;
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

	private void setPanel(String key) {
		assert panelsMap.containsKey(key);
		if (currentPanel != null)
			currentPanel.setModels(null);
		currentPanel = panelsMap.get(key);
		currentPanel.setModels(SelectionManager.instance().getSelectedObjects());
		((CardLayout)getLayout()).show(this, key);
	}

	private void updateSelectModeInfoPanel() {
		List<Object> objs = SelectionManager.instance().getSelectedObjects();
		if (SelectionManager.instance().getSelectedObjectsType() == SpriteModel.class) {
			setPanel("SELECT_SPRITES");
		} else {
			setPanel("SELECT_DEFAULT");
		}
	}
}
