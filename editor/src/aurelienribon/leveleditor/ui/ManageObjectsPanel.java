package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.SelectionManager;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.behaviors.Nameable;
import aurelienribon.utils.AutoTreeModel;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.ObservableList;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ManageObjectsPanel extends javax.swing.JPanel {
	private final Map<Class, ImageIcon> iconsMap = new HashMap<Class, ImageIcon>();

    public ManageObjectsPanel() {
		iconsMap.put(LayerModel.class, new ImageIcon(ManageObjectsPanel.class.getResource("gfx/ic_layers.png")));
		iconsMap.put(SpriteModel.class, new ImageIcon(ManageObjectsPanel.class.getResource("gfx/ic_texture.png")));
		
        initComponents();
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
		tree.setModel(treeModel);
		tree.setCellRenderer(treeCellRenderer);
		tree.setCellEditor(treeCellEditor);
		tree.addTreeSelectionListener(treeSelectionListener);
		SelectionManager.instance().addChangeListener(selectionManagerChangeListener);
		updateUiState();

		treeModel.addTreeModelListener(new TreeModelListener() {
			@Override public void treeNodesChanged(TreeModelEvent e) {}
			@Override public void treeNodesRemoved(TreeModelEvent e) {}
			@Override public void treeStructureChanged(TreeModelEvent e) {}
			@Override public void treeNodesInserted(TreeModelEvent e) {
				tree.expandPath(e.getTreePath());
			}
		});
    }

	private List<Object> convertSelectedPaths() {
		List<Object> list = new ArrayList<Object>();
		TreePath[] paths = tree.getSelectionPaths();
		if (paths != null)
			for (TreePath path : paths)
				list.add(path.getLastPathComponent());
		return Collections.unmodifiableList(list);
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

        treeScrollPane.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.SEPARATOR));
        treeScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tree.setBackground(Theme.TEXTAREA_BACKGROUND);
        tree.setForeground(Theme.TEXTAREA_FOREGROUND);
        tree.setEditable(true);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(addLayerBtn)))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void addLayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLayerBtnActionPerformed
		String name = JOptionPane.showInputDialog(this, "Layer name?");
		if (name != null) {
			LayerModel layer = new LayerModel();
			layer.setName(name);
			LayersManager.instance().getList().add(layer);
		}
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
			if (SelectionManager.instance().getSelectedObjects().contains(child))
				SelectionManager.instance().select(child, false);
		}
	}//GEN-LAST:event_deleteBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLayerBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton moveBottomBtn;
    private javax.swing.JButton moveDownBtn;
    private javax.swing.JButton moveTopBtn;
    private javax.swing.JButton moveUpBtn;
    private javax.swing.JTree tree;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables

	// -------------------------------------------------------------------------
	// TreeSelectionListener
	// -------------------------------------------------------------------------

	private final TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
		@Override public void valueChanged(TreeSelectionEvent e) {
			SelectionManager.instance().removeChangeListener(selectionManagerChangeListener);
			SelectionManager.instance().select(null, true);
			for (Object obj : convertSelectedPaths())
				SelectionManager.instance().select(obj, false);
			updateUiState();
			SelectionManager.instance().addChangeListener(selectionManagerChangeListener);
		}
	};

	private final ChangeListener selectionManagerChangeListener = new ChangeListener() {
		@Override public void propertyChanged(Object source, String propertyName) {
			if (propertyName.equals("selectedObjects")) {
				tree.removeTreeSelectionListener(treeSelectionListener);
				List<Object> selObjs = SelectionManager.instance().getSelectedObjects();
				List<Object> selObjsTree = convertSelectedPaths();
				for (Object obj : selObjs)
					if (!selObjsTree.contains(obj))
						tree.addSelectionPath(treeModel.getPathsMap().get(obj));
				for (Object obj : selObjsTree)
					if (!selObjs.contains(obj))
						tree.removeSelectionPath(treeModel.getPathsMap().get(obj));
				tree.addTreeSelectionListener(treeSelectionListener);
			}
		}
	};

	// -------------------------------------------------------------------------
	// TreeModel
	// -------------------------------------------------------------------------

	private final AutoTreeModel treeModel = new AutoTreeModel() {
		{
			registerRoot(LayersManager.instance());
		}
		
		@Override
		public Object getRoot() {
			return LayersManager.instance();
		}

		@Override
		public Object getChild(Object parent, int index) {
			if (parent instanceof LayersManager) {
				return ((LayersManager)parent).getList().get(index);
			} else if (parent instanceof LayerModel) {
				return ((LayerModel)parent).getSprites().get(index);
			}

			assert false;
			return null;
		}

		@Override
		public int getChildCount(Object parent) {
			if (parent instanceof LayersManager) {
				return ((LayersManager)parent).getList().size();
			} else if (parent instanceof LayerModel) {
				return ((LayerModel)parent).getSprites().size();
			}

			return 0;
		}

		@Override
		public boolean isLeaf(Object node) {
			return false;
		}

		@Override
		public void valueForPathChanged(TreePath path, Object newValue) {
			Nameable obj = (Nameable)path.getLastPathComponent();
			obj.setName((String)newValue);
		}

		@Override
		public int getIndexOfChild(Object parent, Object child) {
			return 0;
		}
	};

	// -------------------------------------------------------------------------
	// TreeCellRenderer
	// -------------------------------------------------------------------------

	private final TreeCellRenderer treeCellRenderer = new TreeCellRenderer() {
		private final JPanel panel = new JPanel(new BorderLayout());
		private final JLabel iconLabel = new JLabel();
		private final JLabel nameLabel = new JLabel();

		{
			iconLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
			nameLabel.setBorder(new EmptyBorder(0, 2, 0, 2));
			panel.setOpaque(false);
			panel.add(iconLabel, BorderLayout.WEST);
			panel.add(nameLabel, BorderLayout.CENTER);
		}

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
			if ((value instanceof Nameable) == false)
				return panel;

			iconLabel.setIcon(iconsMap.get(value.getClass()));
			nameLabel.setText(((Nameable)value).getName());

			if (selected) {
				nameLabel.setBackground(Theme.TEXTAREA_SELECTED_BACKGROUND);
				nameLabel.setForeground(Theme.TEXTAREA_SELECTED_FOREGROUND);
				nameLabel.setOpaque(true);
			} else {
				nameLabel.setForeground(Theme.TEXTAREA_FOREGROUND);
				nameLabel.setOpaque(false);
			}

			return panel;
		}
	};

	// -------------------------------------------------------------------------
	// TreeCellEditor
	// -------------------------------------------------------------------------

	private final TreeCellEditor treeCellEditor = new DefaultCellEditor(new JTextField()) {
		private final JPanel panel = new JPanel(new BorderLayout());
		private final JLabel iconLabel = new JLabel();

		{
			iconLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
			editorComponent.setBackground(Theme.TEXTAREA_BACKGROUND);
			editorComponent.setForeground(Theme.TEXTAREA_FOREGROUND);
			panel.setOpaque(false);
			panel.add(iconLabel, BorderLayout.WEST);
			panel.add(editorComponent, BorderLayout.CENTER);
		}

		@Override
		public boolean isCellEditable(EventObject anEvent) {
			boolean ret = tree.getLastSelectedPathComponent() instanceof Nameable;
			if (anEvent instanceof MouseEvent)
				ret &= ((MouseEvent)anEvent).getClickCount() >= 2;
			return ret;
		}

		@Override
		public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
			assert value instanceof Nameable;
			iconLabel.setIcon(iconsMap.get(value.getClass()));
			((JTextField)editorComponent).setText(((Nameable)value).getName());
			((JTextField)editorComponent).setColumns(15);
			return panel;
		}
	};

	// -------------------------------------------------------------------------
	// Misc
	// -------------------------------------------------------------------------

	private void updateUiState() {
		List<Object> objs = convertSelectedPaths();
		
		moveTopBtn.setEnabled(!objs.isEmpty());
		moveUpBtn.setEnabled(!objs.isEmpty());
		moveDownBtn.setEnabled(!objs.isEmpty());
		moveBottomBtn.setEnabled(!objs.isEmpty());
		deleteBtn.setEnabled(!objs.isEmpty());
	}
}
