package aurelienribon.leveleditor.ui.infopanels;

import aurelienribon.leveleditor.ui.InfoPanelChild;
import aurelienribon.leveleditor.ui.Theme;
import aurelienribon.utils.Changeable;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SelectModeDefaultInfoPanel extends javax.swing.JPanel implements InfoPanelChild {

    public SelectModeDefaultInfoPanel() {
        initComponents();
    }

	@Override
	public void setModel(Changeable model) {
	}

	@Override
	public void dispose() {
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultLbl = new javax.swing.JLabel();

        setBackground(Theme.MAIN_ALT_BACKGROUND);

        defaultLbl.setForeground(Theme.MAIN_ALT_FOREGROUND);
        defaultLbl.setText("<No object selected>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultLbl)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel defaultLbl;
    // End of variables declaration//GEN-END:variables

}
