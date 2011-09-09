package aurelienribon.leveleditor.ui;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ObjectsPanel extends javax.swing.JPanel {
    public ObjectsPanel() {
        initComponents();

		ImageIcon leafIcon = new ImageIcon(ObjectsPanel.class.getResource("gfx/ic_texture.png"));
		if (leafIcon != null) {
			DefaultTreeCellRenderer renderer =
			new DefaultTreeCellRenderer();
			renderer.setLeafIcon(leafIcon);
			tree.setCellRenderer(renderer);
		}
    }
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toggleLayerVisibilityBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();

        toggleLayerVisibilityBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_showHide.png"))); // NOI18N
        toggleLayerVisibilityBtn.setText("Toggle layer visibility");
        toggleLayerVisibilityBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        toggleLayerVisibilityBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        toggleLayerVisibilityBtn.setOpaque(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.SEPARATOR));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tree.setBackground(Theme.TEXTAREA_BACKGROUND);
        tree.setForeground(Theme.TEXTAREA_FOREGROUND);
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        jScrollPane1.setViewportView(tree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toggleLayerVisibilityBtn)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleLayerVisibilityBtn))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton toggleLayerVisibilityBtn;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables

	private class TreeCellRenderer extends DefaultTreeCellRenderer {
		
	}
}
