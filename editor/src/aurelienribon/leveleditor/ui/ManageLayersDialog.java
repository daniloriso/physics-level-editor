package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.models.LayerModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class ManageLayersDialog extends javax.swing.JDialog {
	private final DefaultListModel layersListModel = new DefaultListModel();

    public ManageLayersDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

		layersList.setModel(layersListModel);
		reload();
		addWindowListener(wndListener);
    }

	private final WindowListener wndListener = new WindowAdapter() {
		@Override public void windowOpened(WindowEvent e) {
			LayersManager.instance().addListener(listener);
		}

		@Override public void windowClosing(WindowEvent e) {
			LayersManager.instance().removeListener(listener);
		}
	};

	private final LayersManager.Listener listener = new LayersManager.Listener() {
		@Override
		public void layerAdded(LayerModel layer) {
			reload();
		}

		@Override
		public void layerRemoved(LayerModel layer) {
			reload();
		}

		@Override
		public void layersUpdated() {
			reload();
		}
	};

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mailPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        layersList = new javax.swing.JList();
        ctrlMoveTopBtn = new javax.swing.JButton();
        ctrlMoveUpBtn = new javax.swing.JButton();
        ctrlMoveDownBtn = new javax.swing.JButton();
        ctrlMoveBottomBtn = new javax.swing.JButton();
        ctrlDeleteBtn = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        infoAddLayerBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Layers Manager");

        mailPanel.setBackground(Theme.MAIN_ALT_BACKGROUND);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, Theme.SEPARATOR));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        layersList.setBackground(Theme.TEXTAREA_BACKGROUND);
        layersList.setForeground(Theme.TEXTAREA_FOREGROUND);
        layersList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(layersList);

        ctrlMoveTopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_top.png"))); // NOI18N
        ctrlMoveTopBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        ctrlMoveTopBtn.setOpaque(false);
        ctrlMoveTopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlMoveTopBtnActionPerformed(evt);
            }
        });

        ctrlMoveUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_up.png"))); // NOI18N
        ctrlMoveUpBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        ctrlMoveUpBtn.setOpaque(false);
        ctrlMoveUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlMoveUpBtnActionPerformed(evt);
            }
        });

        ctrlMoveDownBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_down.png"))); // NOI18N
        ctrlMoveDownBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        ctrlMoveDownBtn.setOpaque(false);
        ctrlMoveDownBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlMoveDownBtnActionPerformed(evt);
            }
        });

        ctrlMoveBottomBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_bottom.png"))); // NOI18N
        ctrlMoveBottomBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        ctrlMoveBottomBtn.setOpaque(false);
        ctrlMoveBottomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlMoveBottomBtnActionPerformed(evt);
            }
        });

        ctrlDeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_delete.png"))); // NOI18N
        ctrlDeleteBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        ctrlDeleteBtn.setOpaque(false);
        ctrlDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlDeleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mailPanelLayout = new javax.swing.GroupLayout(mailPanel);
        mailPanel.setLayout(mailPanelLayout);
        mailPanelLayout.setHorizontalGroup(
            mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mailPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctrlMoveTopBtn)
                    .addComponent(ctrlMoveUpBtn)
                    .addComponent(ctrlMoveDownBtn)
                    .addComponent(ctrlMoveBottomBtn)
                    .addComponent(ctrlDeleteBtn))
                .addContainerGap())
        );
        mailPanelLayout.setVerticalGroup(
            mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ctrlMoveTopBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlMoveUpBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlMoveDownBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlMoveBottomBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctrlDeleteBtn)
                .addContainerGap(65, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );

        getContentPane().add(mailPanel, java.awt.BorderLayout.CENTER);

        infoPanel.setBackground(Theme.MAIN_BACKGROUND);
        infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, Theme.SEPARATOR));

        infoAddLayerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_add.png"))); // NOI18N
        infoAddLayerBtn.setText("Add new layer");
        infoAddLayerBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        infoAddLayerBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        infoAddLayerBtn.setOpaque(false);
        infoAddLayerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoAddLayerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(infoAddLayerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoAddLayerBtn)
                .addContainerGap())
        );

        getContentPane().add(infoPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void ctrlMoveTopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlMoveTopBtnActionPerformed
		// TODO add your handling code here:
}//GEN-LAST:event_ctrlMoveTopBtnActionPerformed

	private void ctrlMoveUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlMoveUpBtnActionPerformed
		// TODO add your handling code here:
}//GEN-LAST:event_ctrlMoveUpBtnActionPerformed

	private void ctrlMoveDownBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlMoveDownBtnActionPerformed
		// TODO add your handling code here:
}//GEN-LAST:event_ctrlMoveDownBtnActionPerformed

	private void ctrlMoveBottomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlMoveBottomBtnActionPerformed
		// TODO add your handling code here:
}//GEN-LAST:event_ctrlMoveBottomBtnActionPerformed

	private void ctrlDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlDeleteBtnActionPerformed
		int idx = layersList.getSelectedIndex();
		LayersManager.instance().removeLayer(idx);
}//GEN-LAST:event_ctrlDeleteBtnActionPerformed

	private void infoAddLayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoAddLayerBtnActionPerformed
		String name = JOptionPane.showInputDialog(this, "Layer name?");
		if (name != null)
			LayersManager.instance().addLayer(new LayerModel(name));
}//GEN-LAST:event_infoAddLayerBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ctrlDeleteBtn;
    private javax.swing.JButton ctrlMoveBottomBtn;
    private javax.swing.JButton ctrlMoveDownBtn;
    private javax.swing.JButton ctrlMoveTopBtn;
    private javax.swing.JButton ctrlMoveUpBtn;
    private javax.swing.JButton infoAddLayerBtn;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList layersList;
    private javax.swing.JPanel mailPanel;
    // End of variables declaration//GEN-END:variables

	private void reload() {
		layersListModel.clear();
		for (LayerModel asset : LayersManager.instance().getLayersList())
			layersListModel.addElement(asset.getName());
	}
}
