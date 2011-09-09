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
        renderPanel = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        logoLbl = new javax.swing.JLabel();
        configPanel = new javax.swing.JPanel();
        cfgTitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cfgSetProjectFileBtn = new javax.swing.JButton();
        cfgSaveProjectBtn = new javax.swing.JButton();
        cfgProjectFileField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cfgManageAssetsBtn = new javax.swing.JButton();
        cfgManageLayersBtn = new javax.swing.JButton();
        layersPanel = new javax.swing.JPanel();
        layTitlePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        layToggleVisBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Physics Level Editor");

        mainPanel.setLayout(new java.awt.BorderLayout());

        renderPanel.setLayout(new java.awt.BorderLayout());
        mainPanel.add(renderPanel, java.awt.BorderLayout.CENTER);

        sidePanel.setBackground(Theme.MAIN_BACKGROUND);
        sidePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, Theme.SEPARATOR));

        logoLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/logo.png"))); // NOI18N

        configPanel.setOpaque(false);

        cfgTitlePanel.setBackground(Theme.HEADER_BACKGROUND);
        cfgTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, Theme.SEPARATOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(Theme.HEADER_FOREGROUND);
        jLabel1.setText("Project");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_help.png"))); // NOI18N

        javax.swing.GroupLayout cfgTitlePanelLayout = new javax.swing.GroupLayout(cfgTitlePanel);
        cfgTitlePanel.setLayout(cfgTitlePanelLayout);
        cfgTitlePanelLayout.setHorizontalGroup(
            cfgTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cfgTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
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
        cfgSetProjectFileBtn.setText("Set / load project file");
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

        cfgProjectFileField.setBackground(Theme.TEXTAREA_BACKGROUND);
        cfgProjectFileField.setForeground(Theme.TEXTAREA_FOREGROUND);
        cfgProjectFileField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        cfgProjectFileField.setText("<please select a file>");

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

        cfgManageLayersBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_layers.png"))); // NOI18N
        cfgManageLayersBtn.setText("Manage layers");
        cfgManageLayersBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cfgManageLayersBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        cfgManageLayersBtn.setOpaque(false);
        cfgManageLayersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cfgManageLayersBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout configPanelLayout = new javax.swing.GroupLayout(configPanel);
        configPanel.setLayout(configPanelLayout);
        configPanelLayout.setHorizontalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cfgTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgProjectFileField, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgManageAssetsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgSetProjectFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgSaveProjectBtn)
                .addContainerGap())
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cfgManageLayersBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
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
                .addComponent(cfgProjectFileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgManageAssetsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgManageLayersBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layersPanel.setOpaque(false);

        layTitlePanel.setBackground(Theme.HEADER_BACKGROUND);
        layTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, Theme.SEPARATOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setForeground(Theme.HEADER_FOREGROUND);
        jLabel2.setText("Objects");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_help.png"))); // NOI18N

        javax.swing.GroupLayout layTitlePanelLayout = new javax.swing.GroupLayout(layTitlePanel);
        layTitlePanel.setLayout(layTitlePanelLayout);
        layTitlePanelLayout.setHorizontalGroup(
            layTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        layTitlePanelLayout.setVerticalGroup(
            layTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layToggleVisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_showHide.png"))); // NOI18N
        layToggleVisBtn.setText("Toggle layer visibility");
        layToggleVisBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        layToggleVisBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        layToggleVisBtn.setOpaque(false);

        javax.swing.GroupLayout layersPanelLayout = new javax.swing.GroupLayout(layersPanel);
        layersPanel.setLayout(layersPanelLayout);
        layersPanelLayout.setHorizontalGroup(
            layersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layersPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(layToggleVisBtn)
                .addContainerGap())
        );
        layersPanelLayout.setVerticalGroup(
            layersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layersPanelLayout.createSequentialGroup()
                .addComponent(layTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(layToggleVisBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(layersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(logoLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
				cfgProjectFileField.setText(projectFile.getPath());
		}
	}//GEN-LAST:event_cfgSetProjectFileBtnActionPerformed

	private void cfgSaveProjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfgSaveProjectBtnActionPerformed
		if (projectFile != null) {
			;
		} else {
			JOptionPane.showMessageDialog(this, "Please select a project file first");
		}
	}//GEN-LAST:event_cfgSaveProjectBtnActionPerformed

	private void cfgManageLayersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cfgManageLayersBtnActionPerformed
		ManageLayersDialog dialog = new ManageLayersDialog(this, true);
		centerDialog(dialog);
		dialog.setVisible(true);
	}//GEN-LAST:event_cfgManageLayersBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cfgManageAssetsBtn;
    private javax.swing.JButton cfgManageLayersBtn;
    private javax.swing.JTextField cfgProjectFileField;
    private javax.swing.JButton cfgSaveProjectBtn;
    private javax.swing.JButton cfgSetProjectFileBtn;
    private javax.swing.JPanel cfgTitlePanel;
    private javax.swing.JPanel configPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel layTitlePanel;
    private javax.swing.JButton layToggleVisBtn;
    private javax.swing.JPanel layersPanel;
    private javax.swing.JLabel logoLbl;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel renderPanel;
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
