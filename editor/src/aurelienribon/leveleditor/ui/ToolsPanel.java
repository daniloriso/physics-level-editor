/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ToolsPanel.java
 *
 * Created on 14 sept. 2011, 17:18:04
 */

package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.AppManager;
import java.awt.Component;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class ToolsPanel extends javax.swing.JPanel {
	private Component renderpanel;

    public ToolsPanel() {
        initComponents();
    }

	public void setRenderPanel(Component cmp) {
		renderpanel = cmp;
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        toolSetSelectModeBtn = new javax.swing.JToggleButton();
        toolSetSpriteModeBtn = new javax.swing.JToggleButton();

        setBackground(Theme.MAIN_BACKGROUND);

        btnGroup.add(toolSetSelectModeBtn);
        toolSetSelectModeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_cursor.png"))); // NOI18N
        toolSetSelectModeBtn.setSelected(true);
        toolSetSelectModeBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        toolSetSelectModeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolSetSelectModeBtnActionPerformed(evt);
            }
        });

        btnGroup.add(toolSetSpriteModeBtn);
        toolSetSpriteModeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_texture.png"))); // NOI18N
        toolSetSpriteModeBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        toolSetSpriteModeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolSetSpriteModeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolSetSelectModeBtn)
            .addComponent(toolSetSpriteModeBtn)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolSetSelectModeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolSetSpriteModeBtn))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void toolSetSelectModeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSetSelectModeBtnActionPerformed
		AppManager.instance().setInteractionMode(AppManager.InteractionModes.SELECT);
		if (renderpanel != null)
			renderpanel.requestFocusInWindow();
}//GEN-LAST:event_toolSetSelectModeBtnActionPerformed

	private void toolSetSpriteModeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSetSpriteModeBtnActionPerformed
		AppManager.instance().setInteractionMode(AppManager.InteractionModes.ADD_SPRITES);
		if (renderpanel != null)
			renderpanel.requestFocusInWindow();
}//GEN-LAST:event_toolSetSpriteModeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JToggleButton toolSetSelectModeBtn;
    private javax.swing.JToggleButton toolSetSpriteModeBtn;
    // End of variables declaration//GEN-END:variables

}
