package aurelienribon.leveleditor.ui.infopanels;

import aurelienribon.leveleditor.ui.InfoPanelChild;
import aurelienribon.leveleditor.ui.Theme;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SpritesModeInfoPanel extends InfoPanelChild {
    public SpritesModeInfoPanel() {
        initComponents();
    }

	@Override
	public void setModels(List<Object> models) {
	}
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(Theme.MAIN_ALT_BACKGROUND);

        jLabel1.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel1.setText("<html>\n<b>Help</b><br/>\nChange the asset with <b>&lt;TAB&gt;</b> or <b>&lt;shift&gt;+&lt;TAB&gt;</b>, and click on the screen to place it.\nYou can move/resize/rotate it later with the SELECT tool.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
