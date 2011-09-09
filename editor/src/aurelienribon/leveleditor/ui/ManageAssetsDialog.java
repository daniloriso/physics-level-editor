package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.models.AssetModel;
import aurelienribon.leveleditor.AssetsManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class ManageAssetsDialog extends javax.swing.JDialog {
	private final DefaultListModel assetsListModel = new DefaultListModel();

	public ManageAssetsDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();

		assetsList.setModel(assetsListModel);
		reload();
		addWindowListener(wndListener);
	}

	private final WindowListener wndListener = new WindowAdapter() {
		@Override public void windowOpened(WindowEvent e) {
			AssetsManager.instance().addListener(listener);
		}

		@Override public void windowClosing(WindowEvent e) {
			AssetsManager.instance().removeListener(listener);
		}
	};

	private final AssetsManager.Listener listener = new AssetsManager.Listener() {
		@Override public void assetsAdded(List<AssetModel> assets) {
			reload();
		}

		@Override public void assetsRemoved(List<AssetModel> assets) {
			reload();
		}

		@Override public void assetsUpdated() {
			reload();
		}
	};

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        assetsList = new javax.swing.JList();
        ctrlMoveBottomBtn = new javax.swing.JButton();
        ctrlDeleteBtn = new javax.swing.JButton();
        ctrlMoveDownBtn = new javax.swing.JButton();
        ctrlMoveUpBtn = new javax.swing.JButton();
        ctrlMoveTopBtn = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        infoNameLbl = new javax.swing.JLabel();
        infoPathLbl = new javax.swing.JLabel();
        infoDimensionsLbl = new javax.swing.JLabel();
        infoSizeLbl = new javax.swing.JLabel();
        infoAddAssetBtn = new javax.swing.JButton();
        infoPreviewPanel = new aurelienribon.leveleditor.ui.ImagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Assets Manager");

        mainPanel.setBackground(Theme.MAIN_ALT_BACKGROUND);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, Theme.SEPARATOR));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        assetsList.setBackground(Theme.TEXTAREA_BACKGROUND);
        assetsList.setForeground(Theme.TEXTAREA_FOREGROUND);
        assetsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        assetsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                assetsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(assetsList);

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

        ctrlMoveDownBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_down.png"))); // NOI18N
        ctrlMoveDownBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        ctrlMoveDownBtn.setOpaque(false);
        ctrlMoveDownBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlMoveDownBtnActionPerformed(evt);
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

        ctrlMoveTopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_top.png"))); // NOI18N
        ctrlMoveTopBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        ctrlMoveTopBtn.setOpaque(false);
        ctrlMoveTopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctrlMoveTopBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctrlMoveTopBtn)
                    .addComponent(ctrlMoveUpBtn)
                    .addComponent(ctrlMoveDownBtn)
                    .addComponent(ctrlMoveBottomBtn)
                    .addComponent(ctrlDeleteBtn))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
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
                .addContainerGap(265, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        infoPanel.setBackground(Theme.MAIN_BACKGROUND);
        infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, Theme.SEPARATOR));

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setForeground(Theme.MAIN_FOREGROUND);
        jLabel1.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setForeground(Theme.MAIN_FOREGROUND);
        jLabel4.setText("Path:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setForeground(Theme.MAIN_FOREGROUND);
        jLabel2.setText("Dimensions:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setForeground(Theme.MAIN_FOREGROUND);
        jLabel3.setText("Size:");

        infoNameLbl.setForeground(Theme.MAIN_FOREGROUND);
        infoNameLbl.setText("---");

        infoPathLbl.setForeground(Theme.MAIN_FOREGROUND);
        infoPathLbl.setText("---");

        infoDimensionsLbl.setForeground(Theme.MAIN_FOREGROUND);
        infoDimensionsLbl.setText("---");

        infoSizeLbl.setForeground(Theme.MAIN_FOREGROUND);
        infoSizeLbl.setText("---");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoNameLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPathLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoDimensionsLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoSizeLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(infoNameLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(infoPathLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(infoDimensionsLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(infoSizeLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoAddAssetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_add.png"))); // NOI18N
        infoAddAssetBtn.setText("Add assets");
        infoAddAssetBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        infoAddAssetBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        infoAddAssetBtn.setOpaque(false);
        infoAddAssetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoAddAssetBtnActionPerformed(evt);
            }
        });

        infoPreviewPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, Theme.SEPARATOR));

        javax.swing.GroupLayout infoPreviewPanelLayout = new javax.swing.GroupLayout(infoPreviewPanel);
        infoPreviewPanel.setLayout(infoPreviewPanelLayout);
        infoPreviewPanelLayout.setHorizontalGroup(
            infoPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        infoPreviewPanelLayout.setVerticalGroup(
            infoPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addComponent(infoPreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(infoAddAssetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPreviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(infoAddAssetBtn)
                .addContainerGap())
        );

        getContentPane().add(infoPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void infoAddAssetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoAddAssetBtnActionPerformed
		JFileChooser chooser = new JFileChooser(".");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(true);
		chooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "bmp", "png"));
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			List<AssetModel> assets = new ArrayList<AssetModel>();
			for (File file : chooser.getSelectedFiles())
				assets.add(new AssetModel(file.getPath()));
			AssetsManager.instance().addAssets(assets);
		}
	}//GEN-LAST:event_infoAddAssetBtnActionPerformed

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
		int[] idxs = assetsList.getSelectedIndices();
		AssetsManager.instance().removeAssets(idxs);
	}//GEN-LAST:event_ctrlDeleteBtnActionPerformed

	private void assetsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_assetsListValueChanged
		int[] idxs = assetsList.getSelectedIndices();
		if (idxs.length == 0) {
			infoNameLbl.setText("---");
			infoPathLbl.setText("---");
			infoDimensionsLbl.setText("---");
			infoSizeLbl.setText("---");
			infoPreviewPanel.clearImage();
		} else if (idxs.length == 1) {
			AssetModel asset = AssetsManager.instance().getAsset(idxs[0]);
			infoNameLbl.setText(asset.getName());
			infoPathLbl.setText(asset.getPath());
			infoDimensionsLbl.setText(asset.getWidth() + " x " + asset.getHeight());
			infoSizeLbl.setText(asset.getSize() + " kB");
			infoPreviewPanel.setImage(asset.getImage());
		} else {
			infoNameLbl.setText("---");
			infoPathLbl.setText("---");
			infoDimensionsLbl.setText("---");
			infoSizeLbl.setText("---");
			infoPreviewPanel.clearImage();
		}
	}//GEN-LAST:event_assetsListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList assetsList;
    private javax.swing.JButton ctrlDeleteBtn;
    private javax.swing.JButton ctrlMoveBottomBtn;
    private javax.swing.JButton ctrlMoveDownBtn;
    private javax.swing.JButton ctrlMoveTopBtn;
    private javax.swing.JButton ctrlMoveUpBtn;
    private javax.swing.JButton infoAddAssetBtn;
    private javax.swing.JLabel infoDimensionsLbl;
    private javax.swing.JLabel infoNameLbl;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel infoPathLbl;
    private aurelienribon.leveleditor.ui.ImagePanel infoPreviewPanel;
    private javax.swing.JLabel infoSizeLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

	private void reload() {
		assetsListModel.clear();
		for (AssetModel asset : AssetsManager.instance().getAssetsList())
			assetsListModel.addElement(asset.getPath());
	}
}
