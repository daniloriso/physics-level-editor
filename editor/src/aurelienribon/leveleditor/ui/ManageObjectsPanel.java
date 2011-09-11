package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.models.AssetModel;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.behaviors.Hideable;
import aurelienribon.leveleditor.models.behaviors.Renameable;
import aurelienribon.utils.MutableTreeModel;
import aurelienribon.utils.ObservableList;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ManageObjectsPanel extends javax.swing.JPanel {
	private static final ImageIcon layerIcon = new ImageIcon(ManageObjectsPanel.class.getResource("gfx/ic_layers.png"));
	private static final ImageIcon assetIcon = new ImageIcon(ManageObjectsPanel.class.getResource("gfx/ic_texture.png"));

    public ManageObjectsPanel() {
        initComponents();
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setCellRenderer(treeCellRenderer);
		tree.setModel(new MutableTreeModel(LayersManager.instance()));
		tree.addTreeSelectionListener(treeSelectionListener);
		updateUiState(null);
    }
	
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treeScrollPane = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        addLayerBtn = new javax.swing.JButton();
        moveTopBtn = new javax.swing.JButton();
        moveUpBtn = new javax.swing.JButton();
        moveDownBtn = new javax.swing.JButton();
        moveBottomBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        toggleVisibilityBtn = new javax.swing.JButton();
        renameBtn = new javax.swing.JButton();

        treeScrollPane.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.SEPARATOR));
        treeScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tree.setBackground(Theme.TEXTAREA_BACKGROUND);
        tree.setForeground(Theme.TEXTAREA_FOREGROUND);
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        treeScrollPane.setViewportView(tree);

        addLayerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_add.png"))); // NOI18N
        addLayerBtn.setText("New layer");
        addLayerBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        addLayerBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        addLayerBtn.setOpaque(false);
        addLayerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLayerBtnActionPerformed(evt);
            }
        });

        moveTopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_top.png"))); // NOI18N
        moveTopBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        moveTopBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        moveTopBtn.setOpaque(false);
        moveTopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveTopBtnActionPerformed(evt);
            }
        });

        moveUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_up.png"))); // NOI18N
        moveUpBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        moveUpBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        moveUpBtn.setOpaque(false);
        moveUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpBtnActionPerformed(evt);
            }
        });

        moveDownBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_down.png"))); // NOI18N
        moveDownBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        moveDownBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        moveDownBtn.setOpaque(false);
        moveDownBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownBtnActionPerformed(evt);
            }
        });

        moveBottomBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_bottom.png"))); // NOI18N
        moveBottomBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        moveBottomBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        moveBottomBtn.setOpaque(false);
        moveBottomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveBottomBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_delete.png"))); // NOI18N
        deleteBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        deleteBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        deleteBtn.setOpaque(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        toggleVisibilityBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_showHide.png"))); // NOI18N
        toggleVisibilityBtn.setText("Toggle visibility");
        toggleVisibilityBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        toggleVisibilityBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        toggleVisibilityBtn.setOpaque(false);
        toggleVisibilityBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleVisibilityBtnActionPerformed(evt);
            }
        });

        renameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_rename.png"))); // NOI18N
        renameBtn.setText("Rename");
        renameBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        renameBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        renameBtn.setOpaque(false);
        renameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(toggleVisibilityBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(renameBtn))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(addLayerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveTopBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveUpBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveDownBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveBottomBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn))
            .addComponent(treeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(treeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moveUpBtn)
                    .addComponent(moveDownBtn)
                    .addComponent(moveBottomBtn)
                    .addComponent(deleteBtn)
                    .addComponent(moveTopBtn)
                    .addComponent(addLayerBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toggleVisibilityBtn)
                    .addComponent(renameBtn)))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void toggleVisibilityBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleVisibilityBtnActionPerformed
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			Object obj = path.getLastPathComponent();
			if (obj instanceof Hideable) {
				Hideable o = (Hideable)obj;
				o.setVisible(!o.isVisible());
			}
		}
	}//GEN-LAST:event_toggleVisibilityBtnActionPerformed

	private void addLayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLayerBtnActionPerformed
		String name = JOptionPane.showInputDialog(this, "Layer name?");
		LayerModel layer = new LayerModel();
		layer.setName(name);
		LayersManager.instance().add(layer);
	}//GEN-LAST:event_addLayerBtnActionPerformed

	private void moveTopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveTopBtnActionPerformed
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			Object child = path.getLastPathComponent();
			ObservableList parent = (ObservableList) path.getPathComponent(path.getPathCount()-2);
			parent.remove(child);
			parent.add(0, child);
			tree.setSelectionPath(path);
		}
	}//GEN-LAST:event_moveTopBtnActionPerformed

	private void moveUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpBtnActionPerformed
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			Object child = path.getLastPathComponent();
			ObservableList parent = (ObservableList) path.getPathComponent(path.getPathCount()-2);
			int idx = parent.indexOf(child);
			parent.remove(child);
			parent.add(idx > 0 ? idx-1 : 0, child);
			tree.setSelectionPath(path);
		}
	}//GEN-LAST:event_moveUpBtnActionPerformed

	private void moveDownBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownBtnActionPerformed
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			Object child = path.getLastPathComponent();
			ObservableList parent = (ObservableList) path.getPathComponent(path.getPathCount()-2);
			int idx = parent.indexOf(child);
			int size = parent.size();
			parent.remove(child);
			parent.add(idx < size-1 ? idx+1 : size-1, child);
			tree.setSelectionPath(path);
		}
	}//GEN-LAST:event_moveDownBtnActionPerformed

	private void moveBottomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveBottomBtnActionPerformed
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			Object child = path.getLastPathComponent();
			ObservableList parent = (ObservableList) path.getPathComponent(path.getPathCount()-2);
			int size = parent.size();
			parent.remove(child);
			parent.add(size-1, child);
			tree.setSelectionPath(path);
		}
	}//GEN-LAST:event_moveBottomBtnActionPerformed

	private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			Object child = path.getLastPathComponent();
			ObservableList parent = (ObservableList) path.getPathComponent(path.getPathCount()-2);
			parent.remove(child);
		}
	}//GEN-LAST:event_deleteBtnActionPerformed

	private void renameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameBtnActionPerformed
		TreePath path = tree.getSelectionPath();
		if (path != null) {
			Object obj = path.getLastPathComponent();
			if (obj instanceof Renameable) {
				Renameable o = (Renameable)obj;
				String name = JOptionPane.showInputDialog(this, "New name?", o.getName());
				if (name != null)
					o.setName(name);
			}
		}
	}//GEN-LAST:event_renameBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLayerBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton moveBottomBtn;
    private javax.swing.JButton moveDownBtn;
    private javax.swing.JButton moveTopBtn;
    private javax.swing.JButton moveUpBtn;
    private javax.swing.JButton renameBtn;
    private javax.swing.JButton toggleVisibilityBtn;
    private javax.swing.JTree tree;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables

	private final TreeCellRenderer treeCellRenderer = new TreeCellRenderer() {
		@Override public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {		
			JLabel label = new JLabel();
			label.setBorder(new EmptyBorder(2, 5, 2, 5));

			if (value instanceof LayerModel) {
				LayerModel layer = (LayerModel)value;
				label.setIcon(layerIcon);
				label.setText(layer.getName());
			} else if (value instanceof AssetModel) {
				AssetModel asset = (AssetModel)value;
				label.setIcon(assetIcon);
				label.setText(asset.getName());
			}

			if (selected) {
				label.setBackground(Theme.MAIN_BACKGROUND);
				label.setForeground(Theme.MAIN_FOREGROUND);
				label.setOpaque(true);
			} else {
				label.setForeground(Theme.TEXTAREA_FOREGROUND);
				label.setOpaque(false);
			}

			return label;
		}
	};

	private final TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
		@Override public void valueChanged(TreeSelectionEvent e) {
			TreePath path = e.getNewLeadSelectionPath();
			Object elem = path != null ? path.getLastPathComponent() : null;
			updateUiState(elem);

			if (elem != null && elem instanceof LayerModel)
				LayersManager.instance().setWorkingLayer((LayerModel)elem);
		}
	};

	private void updateUiState(Object selectedObj) {
		renameBtn.setEnabled(selectedObj instanceof Renameable);
		toggleVisibilityBtn.setEnabled(selectedObj instanceof Hideable);
		moveTopBtn.setEnabled(selectedObj != null);
		moveUpBtn.setEnabled(selectedObj != null);
		moveDownBtn.setEnabled(selectedObj != null);
		moveBottomBtn.setEnabled(selectedObj != null);
		deleteBtn.setEnabled(selectedObj != null);
	}
}
