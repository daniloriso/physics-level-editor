package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.models.LayerModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class MainWindow extends javax.swing.JFrame {
	private File projectFile;

	public MainWindow(Component canvas) {
        initComponents();
		renderPanelHolder.add(canvas, BorderLayout.CENTER);
		AppManager.instance().setRenderCanvas(canvas);
		canvas.requestFocusInWindow();

		final Timer updateTimer = new Timer(500, updateTimerActionListener);
		updateTimer.setInitialDelay(0);
		updateTimer.start();

		addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				updateTimer.stop();
			}
		});
    }

	private final ActionListener updateTimerActionListener = new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
			LayerModel layer = LayersManager.instance().getWorkingLayer();
			if (layer == null) {
				wkCurrentLayerLbl.setForeground(Color.RED);
				wkCurrentLayerLbl.setText("<no layer selected>");
			} else if (!layer.getName().equals(wkCurrentLayerLbl.getText())) {
				wkCurrentLayerLbl.setForeground(Theme.MAIN_FOREGROUND);
				wkCurrentLayerLbl.setText(layer.getName());
			}
		}
	};

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolsBtnGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        workingPanel = new javax.swing.JPanel();
        renderPanelHolder = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        wkCurrentLayerLbl = new javax.swing.JLabel();
        sidePanel1 = new javax.swing.JPanel();
        configPanel = new javax.swing.JPanel();
        setLevelFileBtn = new javax.swing.JButton();
        cfgSaveLevelBtn = new javax.swing.JButton();
        cfgLevelFileField = new javax.swing.JTextField();
        cfgManageAssetsBtn = new javax.swing.JButton();
        cfgManageAssetsBtn1 = new javax.swing.JButton();
        objectsPanel = new javax.swing.JPanel();
        objManagerPanel = new aurelienribon.leveleditor.ui.ManageObjectsPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        infoPanel = new aurelienribon.leveleditor.ui.InfoPanel();
        sidePanel2 = new javax.swing.JPanel();
        toolsPanel = new aurelienribon.leveleditor.ui.ToolsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Physics Level Editor");

        mainPanel.setLayout(new java.awt.BorderLayout());

        workingPanel.setBackground(Theme.MAIN_BACKGROUND);

        renderPanelHolder.setBackground(Theme.MAIN_ALT_BACKGROUND);
        renderPanelHolder.setLayout(new java.awt.BorderLayout());

        jLabel6.setForeground(Theme.MAIN_FOREGROUND);
        jLabel6.setText("Current layer:");

        wkCurrentLayerLbl.setFont(new java.awt.Font("Tahoma", 1, 11));
        wkCurrentLayerLbl.setForeground(Theme.MAIN_FOREGROUND);
        wkCurrentLayerLbl.setText("<no layer selected>");

        javax.swing.GroupLayout workingPanelLayout = new javax.swing.GroupLayout(workingPanel);
        workingPanel.setLayout(workingPanelLayout);
        workingPanelLayout.setHorizontalGroup(
            workingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workingPanelLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wkCurrentLayerLbl)
                .addContainerGap())
            .addComponent(renderPanelHolder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        workingPanelLayout.setVerticalGroup(
            workingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(workingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(wkCurrentLayerLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(renderPanelHolder, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(workingPanel, java.awt.BorderLayout.CENTER);

        sidePanel1.setBackground(Theme.MAIN_BACKGROUND);

        configPanel.setBackground(Theme.MAIN_ALT_BACKGROUND);

        setLevelFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_gear.png"))); // NOI18N
        setLevelFileBtn.setText("Set / load level file");
        setLevelFileBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        setLevelFileBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        setLevelFileBtn.setOpaque(false);
        setLevelFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setLevelFileBtnActionPerformed(evt);
            }
        });

        cfgSaveLevelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_save.png"))); // NOI18N
        cfgSaveLevelBtn.setText("Save");
        cfgSaveLevelBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cfgSaveLevelBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        cfgSaveLevelBtn.setOpaque(false);
        cfgSaveLevelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfgSaveLevelBtnActionPerformed(evt);
            }
        });

        cfgLevelFileField.setBackground(Theme.TEXTAREA_BACKGROUND);
        cfgLevelFileField.setForeground(Theme.TEXTAREA_FOREGROUND);
        cfgLevelFileField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cfgLevelFileField.setText("<please select a file>");

        cfgManageAssetsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_texture.png"))); // NOI18N
        cfgManageAssetsBtn.setText("Manage assets");
        cfgManageAssetsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cfgManageAssetsBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        cfgManageAssetsBtn.setOpaque(false);
        cfgManageAssetsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfgManageAssetsBtnActionPerformed(evt);
            }
        });

        cfgManageAssetsBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_pbe.png"))); // NOI18N
        cfgManageAssetsBtn1.setText("Launch Body Editor");
        cfgManageAssetsBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cfgManageAssetsBtn1.setMargin(new java.awt.Insets(2, 5, 2, 5));
        cfgManageAssetsBtn1.setOpaque(false);
        cfgManageAssetsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfgManageAssetsBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout configPanelLayout = new javax.swing.GroupLayout(configPanel);
        configPanel.setLayout(configPanelLayout);
        configPanelLayout.setHorizontalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cfgLevelFileField, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createSequentialGroup()
                        .addComponent(setLevelFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cfgSaveLevelBtn))
                    .addGroup(configPanelLayout.createSequentialGroup()
                        .addComponent(cfgManageAssetsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cfgManageAssetsBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                .addContainerGap())
        );
        configPanelLayout.setVerticalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setLevelFileBtn)
                    .addComponent(cfgSaveLevelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgLevelFileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cfgManageAssetsBtn)
                    .addComponent(cfgManageAssetsBtn1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        objectsPanel.setBackground(Theme.MAIN_ALT_BACKGROUND);

        objManagerPanel.setOpaque(false);

        javax.swing.GroupLayout objectsPanelLayout = new javax.swing.GroupLayout(objectsPanel);
        objectsPanel.setLayout(objectsPanelLayout);
        objectsPanelLayout.setHorizontalGroup(
            objectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objectsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(objManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        objectsPanelLayout.setVerticalGroup(
            objectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, objectsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(objManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(Theme.MAIN_FOREGROUND);
        jLabel2.setText("-- Objects");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setForeground(Theme.MAIN_FOREGROUND);
        jLabel1.setText("-- Configuration");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(Theme.MAIN_FOREGROUND);
        jLabel3.setText("-- Selection");

        javax.swing.GroupLayout sidePanel1Layout = new javax.swing.GroupLayout(sidePanel1);
        sidePanel1.setLayout(sidePanel1Layout);
        sidePanel1Layout.setHorizontalGroup(
            sidePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(objectsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(configPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addContainerGap())
        );
        sidePanel1Layout.setVerticalGroup(
            sidePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(sidePanel1, java.awt.BorderLayout.EAST);

        sidePanel2.setBackground(Theme.MAIN_BACKGROUND);

        toolsPanel.setOpaque(false);

        javax.swing.GroupLayout sidePanel2Layout = new javax.swing.GroupLayout(sidePanel2);
        sidePanel2.setLayout(sidePanel2Layout);
        sidePanel2Layout.setHorizontalGroup(
            sidePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidePanel2Layout.setVerticalGroup(
            sidePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanel2Layout.createSequentialGroup()
                .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(543, Short.MAX_VALUE))
        );

        mainPanel.add(sidePanel2, java.awt.BorderLayout.WEST);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void cfgManageAssetsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfgManageAssetsBtnActionPerformed
		ManageAssetsDialog dialog = new ManageAssetsDialog(this, true);
		centerDialog(dialog);
		dialog.setVisible(true);
	}//GEN-LAST:event_cfgManageAssetsBtnActionPerformed

	private void setLevelFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setLevelFileBtnActionPerformed
		JFileChooser chooser = new JFileChooser(".");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(false);
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			projectFile = chooser.getSelectedFile();
			if (projectFile != null)
				cfgLevelFileField.setText(projectFile.getPath());
		}
	}//GEN-LAST:event_setLevelFileBtnActionPerformed

	private void cfgSaveLevelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfgSaveLevelBtnActionPerformed
		if (projectFile != null) {
			;
		} else {
			JOptionPane.showMessageDialog(this, "Please select a level file first");
		}
	}//GEN-LAST:event_cfgSaveLevelBtnActionPerformed

	private void cfgManageAssetsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfgManageAssetsBtn1ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_cfgManageAssetsBtn1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cfgLevelFileField;
    private javax.swing.JButton cfgManageAssetsBtn;
    private javax.swing.JButton cfgManageAssetsBtn1;
    private javax.swing.JButton cfgSaveLevelBtn;
    private javax.swing.JPanel configPanel;
    private aurelienribon.leveleditor.ui.InfoPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel mainPanel;
    private aurelienribon.leveleditor.ui.ManageObjectsPanel objManagerPanel;
    private javax.swing.JPanel objectsPanel;
    private javax.swing.JPanel renderPanelHolder;
    private javax.swing.JButton setLevelFileBtn;
    private javax.swing.JPanel sidePanel1;
    private javax.swing.JPanel sidePanel2;
    private javax.swing.ButtonGroup toolsBtnGroup;
    private aurelienribon.leveleditor.ui.ToolsPanel toolsPanel;
    private javax.swing.JLabel wkCurrentLayerLbl;
    private javax.swing.JPanel workingPanel;
    // End of variables declaration//GEN-END:variables

	public void centerDialog(Dialog dialog) {
		Dimension size = getSize();
		Point loc = getLocationOnScreen();
		Dimension dialogSize = dialog.getSize();
		loc.x += (size.width  - dialogSize.width)/2;
		loc.y += (size.height - dialogSize.height)/2;
		dialog.setBounds(loc.x, loc.y, dialogSize.width, dialogSize.height);
	}
}
