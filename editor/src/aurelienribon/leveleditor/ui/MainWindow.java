package aurelienribon.leveleditor.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class MainWindow extends javax.swing.JFrame {
	private File projectFile;

	public MainWindow(final Component canvas) {
        initComponents();
		renderPanel.add(canvas, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolsBtnGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        workingPanel = new javax.swing.JPanel();
        renderPanel = new javax.swing.JPanel();
        toolsPanel = new aurelienribon.leveleditor.ui.ToolsPanel();
        infoPanel = new aurelienribon.leveleditor.ui.InfoPanel();
        sidePanel = new javax.swing.JPanel();
        configPanel = new javax.swing.JPanel();
        cfgTitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        setLevelFileBtn = new javax.swing.JButton();
        cfgSaveLevelBtn = new javax.swing.JButton();
        cfgLevelFileField = new javax.swing.JTextField();
        cfgManageAssetsBtn = new javax.swing.JButton();
        objectsPanel = new javax.swing.JPanel();
        objTitlePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        objManagerPanel = new aurelienribon.leveleditor.ui.ManageObjectsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Physics Level Editor");

        mainPanel.setLayout(new java.awt.BorderLayout());

        workingPanel.setBackground(Theme.MAIN_BACKGROUND);

        renderPanel.setBackground(Theme.MAIN_ALT_BACKGROUND);
        renderPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.SEPARATOR));
        renderPanel.setLayout(new java.awt.BorderLayout());

        infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.SEPARATOR));

        javax.swing.GroupLayout workingPanelLayout = new javax.swing.GroupLayout(workingPanel);
        workingPanel.setLayout(workingPanelLayout);
        workingPanelLayout.setHorizontalGroup(
            workingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(workingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addComponent(renderPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
                .addContainerGap())
        );
        workingPanelLayout.setVerticalGroup(
            workingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(workingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, workingPanelLayout.createSequentialGroup()
                        .addComponent(renderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        mainPanel.add(workingPanel, java.awt.BorderLayout.CENTER);

        sidePanel.setBackground(Theme.MAIN_BACKGROUND);
        sidePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, Theme.SEPARATOR));

        configPanel.setOpaque(false);

        cfgTitlePanel.setBackground(Theme.HEADER_BACKGROUND);
        cfgTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, Theme.SEPARATOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(Theme.HEADER_FOREGROUND);
        jLabel1.setText("Level");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_help.png"))); // NOI18N

        javax.swing.GroupLayout cfgTitlePanelLayout = new javax.swing.GroupLayout(cfgTitlePanel);
        cfgTitlePanel.setLayout(cfgTitlePanelLayout);
        cfgTitlePanelLayout.setHorizontalGroup(
            cfgTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cfgTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        cfgTitlePanelLayout.setVerticalGroup(
            cfgTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout configPanelLayout = new javax.swing.GroupLayout(configPanel);
        configPanel.setLayout(configPanelLayout);
        configPanelLayout.setHorizontalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cfgTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(configPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cfgLevelFileField, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(setLevelFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cfgSaveLevelBtn)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgManageAssetsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        configPanelLayout.setVerticalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setLevelFileBtn)
                    .addComponent(cfgSaveLevelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgLevelFileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cfgManageAssetsBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        objectsPanel.setOpaque(false);

        objTitlePanel.setBackground(Theme.HEADER_BACKGROUND);
        objTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, Theme.SEPARATOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(Theme.HEADER_FOREGROUND);
        jLabel2.setText("Objects");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_help.png"))); // NOI18N

        javax.swing.GroupLayout objTitlePanelLayout = new javax.swing.GroupLayout(objTitlePanel);
        objTitlePanel.setLayout(objTitlePanelLayout);
        objTitlePanelLayout.setHorizontalGroup(
            objTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        objTitlePanelLayout.setVerticalGroup(
            objTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(jLabel4))
        );

        objManagerPanel.setOpaque(false);

        javax.swing.GroupLayout objectsPanelLayout = new javax.swing.GroupLayout(objectsPanel);
        objectsPanel.setLayout(objectsPanelLayout);
        objectsPanelLayout.setHorizontalGroup(
            objectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(objTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(objectsPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(objManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        objectsPanelLayout.setVerticalGroup(
            objectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objectsPanelLayout.createSequentialGroup()
                .addComponent(objTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(objManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(objectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(configPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(sidePanel, java.awt.BorderLayout.EAST);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cfgLevelFileField;
    private javax.swing.JButton cfgManageAssetsBtn;
    private javax.swing.JButton cfgSaveLevelBtn;
    private javax.swing.JPanel cfgTitlePanel;
    private javax.swing.JPanel configPanel;
    private aurelienribon.leveleditor.ui.InfoPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel mainPanel;
    private aurelienribon.leveleditor.ui.ManageObjectsPanel objManagerPanel;
    private javax.swing.JPanel objTitlePanel;
    private javax.swing.JPanel objectsPanel;
    private javax.swing.JPanel renderPanel;
    private javax.swing.JButton setLevelFileBtn;
    private javax.swing.JPanel sidePanel;
    private javax.swing.ButtonGroup toolsBtnGroup;
    private aurelienribon.leveleditor.ui.ToolsPanel toolsPanel;
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
