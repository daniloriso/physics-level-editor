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
				holderPanel.removeAll();
				InteractionModes mode = AppManager.instance().getInteractionMode();
				switch (mode) {
					case SELECT:
						holderPanel.add(new SelectModeInfoPanel(), BorderLayout.CENTER);
						break;
					case ADD_SPRITES:
						holderPanel.add(new SpritesModeInfoPanel(), BorderLayout.CENTER);
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

        holderPanel = new javax.swing.JPanel();
        initialPanel = new aurelienribon.leveleditor.ui.infopanels.SelectModeInfoPanel();

        setBackground(Theme.MAIN_ALT_BACKGROUND);

        holderPanel.setOpaque(false);
        holderPanel.setLayout(new java.awt.BorderLayout());

        initialPanel.setOpaque(false);
        holderPanel.add(initialPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(holderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(holderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel holderPanel;
    private aurelienribon.leveleditor.ui.infopanels.SelectModeInfoPanel initialPanel;
    // End of variables declaration//GEN-END:variables

}
