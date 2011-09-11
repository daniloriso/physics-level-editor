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

        mainPanel = new javax.swing.JPanel();
        renderPanelWrapper = new javax.swing.JPanel();
        renderPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        logoLbl = new javax.swing.JLabel();
        configPanel = new javax.swing.JPanel();
        cfgTitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cfgSetProjectFileBtn = new javax.swing.JButton();
        cfgSaveProjectBtn = new javax.swing.JButton();
        cfgLevelFileField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cfgManageAssetsBtn = new javax.swing.JButton();
        objectsPanel = new javax.swing.JPanel();
        objTitlePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        objManagerPanel = new aurelienribon.leveleditor.ui.ManageObjectsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Physics Level Editor");

        mainPanel.setLayout(new java.awt.BorderLayout());

        renderPanelWrapper.setBackground(Theme.MAIN_BACKGROUND);

        renderPanel.setBackground(Theme.MAIN_ALT_BACKGROUND);
        renderPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.SEPARATOR));
        renderPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout renderPanelWrapperLayout = new javax.swing.GroupLayout(renderPanelWrapper);
        renderPanelWrapper.setLayout(renderPanelWrapperLayout);
        renderPanelWrapperLayout.setHorizontalGroup(
            renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
            .addGroup(renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(renderPanelWrapperLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(renderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)))
        );
        renderPanelWrapperLayout.setVerticalGroup(
            renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(renderPanelWrapperLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(renderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        mainPanel.add(renderPanelWrapper, java.awt.BorderLayout.CENTER);

        sidePanel.setBackground(Theme.MAIN_BACKGROUND);

        logoLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/logo.png"))); // NOI18N

        configPanel.setOpaque(false);

        cfgTitlePanel.setBackground(Theme.HEADER_BACKGROUND);
        cfgTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, Theme.SEPARATOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        cfgTitlePanelLayout.setVerticalGroup(
            cfgTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cfgTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cfgTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cfgSetProjectFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_gear.png"))); // NOI18N
        cfgSetProjectFileBtn.setText("Set / load level file");
        cfgSetProjectFileBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cfgSetProjectFileBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        cfgSetProjectFileBtn.setOpaque(false);
        cfgSetProjectFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfgSetProjectFileBtnActionPerformed(evt);
            }
        });

        cfgSaveProjectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_save.png"))); // NOI18N
        cfgSaveProjectBtn.setText("Save");
        cfgSaveProjectBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cfgSaveProjectBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        cfgSaveProjectBtn.setOpaque(false);
        cfgSaveProjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfgSaveProjectBtnActionPerformed(evt);
            }
        });

        cfgLevelFileField.setBackground(Theme.TEXTAREA_BACKGROUND);
        cfgLevelFileField.setForeground(Theme.TEXTAREA_FOREGROUND);
        cfgLevelFileField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cfgLevelFileField.setText("<please select a file>");

        jSeparator1.setBackground(Theme.MAIN_BACKGROUND);
        jSeparator1.setForeground(Theme.SEPARATOR);

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
            .addComponent(cfgTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgLevelFileField, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgSetProjectFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgSaveProjectBtn)
                .addContainerGap())
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgManageAssetsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );
        configPanelLayout.setVerticalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addComponent(cfgTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cfgSetProjectFileBtn)
                    .addComponent(cfgSaveProjectBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgLevelFileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgManageAssetsBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        objectsPanel.setOpaque(false);

        objTitlePanel.setBackground(Theme.HEADER_BACKGROUND);
        objTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, Theme.SEPARATOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        objTitlePanelLayout.setVerticalGroup(
            objTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(objTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        objManagerPanel.setOpaque(false);

        javax.swing.GroupLayout objectsPanelLayout = new javax.swing.GroupLayout(objectsPanel);
        objectsPanel.setLayout(objectsPanelLayout);
        objectsPanelLayout.setHorizontalGroup(
            objectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(objTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(objectsPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(objManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        objectsPanelLayout.setVerticalGroup(
            objectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objectsPanelLayout.createSequentialGroup()
                .addComponent(objTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(objManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(objectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(logoLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

	private void cfgSetProjectFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfgSetProjectFileBtnActionPerformed
		JFileChooser chooser = new JFileChooser(".");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(false);
		if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			projectFile = chooser.getSelectedFile();
			if (projectFile != null)
				cfgLevelFileField.setText(projectFile.getPath());
		}
	}//GEN-LAST:event_cfgSetProjectFileBtnActionPerformed

	private void cfgSaveProjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfgSaveProjectBtnActionPerformed
		if (projectFile != null) {
			;
		} else {
			JOptionPane.showMessageDialog(this, "Please select a project file first");
		}
	}//GEN-LAST:event_cfgSaveProjectBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cfgLevelFileField;
    private javax.swing.JButton cfgManageAssetsBtn;
    private javax.swing.JButton cfgSaveProjectBtn;
    private javax.swing.JButton cfgSetProjectFileBtn;
    private javax.swing.JPanel cfgTitlePanel;
    private javax.swing.JPanel configPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoLbl;
    private javax.swing.JPanel mainPanel;
    private aurelienribon.leveleditor.ui.ManageObjectsPanel objManagerPanel;
    private javax.swing.JPanel objTitlePanel;
    private javax.swing.JPanel objectsPanel;
    private javax.swing.JPanel renderPanel;
    private javax.swing.JPanel renderPanelWrapper;
    private javax.swing.JPanel sidePanel;
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
