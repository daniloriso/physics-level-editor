package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.ui.infopanels.SelectModeInfoPanel;
import aurelienribon.leveleditor.ui.infopanels.SpritesModeInfoPanel;
import aurelienribon.utils.ChangeListener;
import java.awt.BorderLayout;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class InfoPanel extends javax.swing.JPanel {
    public InfoPanel() {
        initComponents();
		AppManager.instance().addChangeListener(appChangeListener);
    }

	private final ChangeListener appChangeListener = new ChangeListener() {
		@Override public void propertyChanged(Object source, String propertyName) {
			if (propertyName.equals("interactionMode")) {
				removeAll();
				InteractionModes mode = AppManager.instance().getInteractionMode();
				switch (mode) {
					case SELECT:
						add(new SelectModeInfoPanel(), BorderLayout.CENTER);
						break;
					case ADD_SPRITES:
						add(new SpritesModeInfoPanel(), BorderLayout.CENTER);
						break;
					default: assert false;
				}
				revalidate();
			}
		}
	};

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        initialPanel = new aurelienribon.leveleditor.ui.infopanels.SelectModeInfoPanel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());
        add(initialPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private aurelienribon.leveleditor.ui.infopanels.SelectModeInfoPanel initialPanel;
    // End of variables declaration//GEN-END:variables

}
