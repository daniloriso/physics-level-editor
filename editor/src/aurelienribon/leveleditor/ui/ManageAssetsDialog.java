package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.AssetsManager;
import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.leveleditor.utils.AssetLoader;
import aurelienribon.utils.AutoListModel;
import java.awt.Component;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class ManageAssetsDialog extends javax.swing.JDialog {
	private final ImageIcon assetIcon = new ImageIcon(ManageObjectsPanel.class.getResource("gfx/ic_texture.png"));

	public ManageAssetsDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		assetsList.setModel(new AutoListModel(AssetsManager.instance().getList()));
		assetsList.setCellRenderer(listCellRdr);
	}

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
        infoPathField = new javax.swing.JTextField();
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
                .addContainerGap(259, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
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

        infoPathField.setBackground(Theme.TEXTAREA_BACKGROUND);
        infoPathField.setForeground(Theme.TEXTAREA_FOREGROUND);
        infoPathField.setText("---");

        infoDimensionsLbl.setForeground(Theme.MAIN_FOREGROUND);
        infoDimensionsLbl.setText("---");

        infoSizeLbl.setForeground(Theme.MAIN_FOREGROUND);
        infoSizeLbl.setText("---");

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
                        .addComponent(infoPathField, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoDimensionsLbl))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoSizeLbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(infoAddAssetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                    .addComponent(infoPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(infoDimensionsLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(infoSizeLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(infoAddAssetBtn)
                .addContainerGap())
        );

        infoPreviewPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, Theme.SEPARATOR));

        javax.swing.GroupLayout infoPreviewPanelLayout = new javax.swing.GroupLayout(infoPreviewPanel);
        infoPreviewPanel.setLayout(infoPreviewPanelLayout);
        infoPreviewPanelLayout.setHorizontalGroup(
            infoPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        infoPreviewPanelLayout.setVerticalGroup(
            infoPreviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addComponent(infoPreviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPreviewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
			for (File file : chooser.getSelectedFiles()) {
				AssetInfo info = AssetLoader.getAssetInfo(file.getPath());
				AssetsManager.instance().getList().add(info);
			}
		}
	}//GEN-LAST:event_infoAddAssetBtnActionPerformed

	private void ctrlMoveTopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlMoveTopBtnActionPerformed
		Object[] os = assetsList.getSelectedValues();
		for (int i=os.length-1; i>=0; i--) {
			AssetInfo asset = (AssetInfo)os[i];
			AssetsManager.instance().getList().remove(asset);
			AssetsManager.instance().getList().add(0, asset);
		}
		select(os);
	}//GEN-LAST:event_ctrlMoveTopBtnActionPerformed

	private void ctrlMoveUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlMoveUpBtnActionPerformed
		Object[] os = assetsList.getSelectedValues();
		for (int i=os.length-1; i>=0; i--) {
			AssetInfo asset = (AssetInfo)os[i];
			int idx = AssetsManager.instance().getList().indexOf(asset);
			AssetsManager.instance().getList().remove(asset);
			AssetsManager.instance().getList().add(idx > 0 ? idx-1 : 0, asset);
		}
		select(os);
	}//GEN-LAST:event_ctrlMoveUpBtnActionPerformed

	private void ctrlMoveDownBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlMoveDownBtnActionPerformed
		Object[] os = assetsList.getSelectedValues();
		int size = AssetsManager.instance().getList().size();
		for (int i=os.length-1; i>=0; i--) {
			AssetInfo asset = (AssetInfo)os[i];
			int idx = AssetsManager.instance().getList().indexOf(asset);
			AssetsManager.instance().getList().remove(asset);
			AssetsManager.instance().getList().add(idx < size-1 ? idx+1 : size-1, asset);
		}
		select(os);
	}//GEN-LAST:event_ctrlMoveDownBtnActionPerformed

	private void ctrlMoveBottomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlMoveBottomBtnActionPerformed
		Object[] os = assetsList.getSelectedValues();
		int size = AssetsManager.instance().getList().size();
		for (int i=0, n=os.length; i<n; i++) {
			AssetInfo asset = (AssetInfo)os[i];
			AssetsManager.instance().getList().remove(asset);
			AssetsManager.instance().getList().add(size-1, asset);
		}
		select(os);
	}//GEN-LAST:event_ctrlMoveBottomBtnActionPerformed

	private void ctrlDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctrlDeleteBtnActionPerformed
		int[] idxs = assetsList.getSelectedIndices();
		for (int i=idxs.length-1; i>=0; i--)
			AssetsManager.instance().getList().remove(idxs[i]);
	}//GEN-LAST:event_ctrlDeleteBtnActionPerformed

	private void assetsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_assetsListValueChanged
		int[] idxs = assetsList.getSelectedIndices();
		if (idxs.length == 0) {
			infoNameLbl.setText("---");
			infoPathField.setText("---");
			infoDimensionsLbl.setText("---");
			infoSizeLbl.setText("---");
			infoPreviewPanel.clearImage();
		} else if (idxs.length == 1) {
			AssetInfo asset = AssetsManager.instance().getList().get(idxs[0]);
			infoNameLbl.setText(asset.getName());
			infoPathField.setText(asset.getPath());
			infoDimensionsLbl.setText(asset.getWidth() + " x " + asset.getHeight());
			infoSizeLbl.setText(asset.getFileSize() + " kB");
			infoPreviewPanel.setImage(AssetLoader.getAssetImage(asset));
		} else {
			infoNameLbl.setText("---");
			infoPathField.setText("---");
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
    private javax.swing.JTextField infoPathField;
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

	private final ListCellRenderer listCellRdr = new ListCellRenderer() {
		@Override public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			JLabel label = new JLabel();
			label.setBorder(new EmptyBorder(2, 5, 2, 5));
			label.setIcon(assetIcon);
			label.setText(((AssetInfo)value).getPath());

			if (isSelected) {
				label.setBackground(Theme.TEXTAREA_SELECTED_BACKGROUND);
				label.setForeground(Theme.TEXTAREA_SELECTED_FOREGROUND);
				label.setOpaque(true);
			} else {
				label.setForeground(Theme.TEXTAREA_FOREGROUND);
				label.setOpaque(false);
			}

			return label;
		}
	};

	private void select(Object[] assets) {
		if (assets.length > 0) {
			int[] idxs = new int[assets.length];
			for (int i=0, n=idxs.length; i<n; i++)
				idxs[i] = AssetsManager.instance().getList().indexOf((AssetInfo)assets[i]);
			assetsList.setSelectedIndices(idxs);
		}
	}
}
