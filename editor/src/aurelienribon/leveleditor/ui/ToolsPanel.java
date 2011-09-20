package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.AppManager;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class ToolsPanel extends javax.swing.JPanel {
    public ToolsPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        toolSetSelectModeBtn = new javax.swing.JToggleButton();
        toolSetSpriteModeBtn = new javax.swing.JToggleButton();

        btnGroup.add(toolSetSelectModeBtn);
        toolSetSelectModeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_cursor_24.png"))); // NOI18N
        toolSetSelectModeBtn.setSelected(true);
        toolSetSelectModeBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        toolSetSelectModeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolSetSelectModeBtnActionPerformed(evt);
            }
        });

        btnGroup.add(toolSetSpriteModeBtn);
        toolSetSpriteModeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_texture_24.png"))); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolSetSelectModeBtn)
                    .addComponent(toolSetSpriteModeBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toolSetSelectModeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolSetSpriteModeBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void toolSetSelectModeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSetSelectModeBtnActionPerformed
		AppManager.instance().setInteractionMode(AppManager.InteractionModes.SELECT);
		AppManager.instance().getRenderCanvas().requestFocusInWindow();
}//GEN-LAST:event_toolSetSelectModeBtnActionPerformed

	private void toolSetSpriteModeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSetSpriteModeBtnActionPerformed
		AppManager.instance().setInteractionMode(AppManager.InteractionModes.ADD_SPRITES);
		AppManager.instance().getRenderCanvas().requestFocusInWindow();
}//GEN-LAST:event_toolSetSpriteModeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JToggleButton toolSetSelectModeBtn;
    private javax.swing.JToggleButton toolSetSpriteModeBtn;
    // End of variables declaration//GEN-END:variables

}
