package aurelienribon.leveleditor.ui;

import aurelienribon.leveleditor.AppManager;
import aurelienribon.leveleditor.AppManager.InteractionModes;
import aurelienribon.leveleditor.AssetsManager;
import aurelienribon.leveleditor.LayersManager;
import aurelienribon.leveleditor.ui.infopanels.SelectModeInfoPanel;
import aurelienribon.leveleditor.ui.infopanels.SpritesModeInfoPanel;
import aurelienribon.utils.ChangeListener;
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

		LayersManager.instance().addChangeListener(new ChangeListener() {
			@Override public void propertyChanged(Object source, String propertyName) {
				if (propertyName.equals("workingLayer")) {
					miscCurrentLayerLbl.setText(((LayersManager)source).getWorkingLayer().getName());
				}
			}
		});

		AppManager.instance().addChangeListener(new ChangeListener() {
			@Override public void propertyChanged(Object source, String propertyName) {
				if (propertyName.equals("interactionMode")) {
					infoPanel.removeAll();
					InteractionModes mode = AppManager.instance().getInteractionMode();
					switch (mode) {
						case SELECT:
							infoPanel.add(new SelectModeInfoPanel(), BorderLayout.CENTER);
							break;
						case ADD_SPRITES:
							infoPanel.add(new SpritesModeInfoPanel(), BorderLayout.CENTER);
							break;
						default: assert false;
					}
					infoPanel.revalidate();
				}
			}
		});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolsBtnGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        renderPanelWrapper = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        miscCurrentLayerLbl = new javax.swing.JLabel();
        renderPanel = new javax.swing.JPanel();
        toolsPanel = new javax.swing.JPanel();
        toolSetSelectModeBtn = new javax.swing.JToggleButton();
        toolSetSpriteModeBtn = new javax.swing.JToggleButton();
        infoPanel = new javax.swing.JPanel();
        dummyInfoPanel = new aurelienribon.leveleditor.ui.infopanels.SelectModeInfoPanel();
        sidePanel = new javax.swing.JPanel();
        logoLbl = new javax.swing.JLabel();
        configPanel = new javax.swing.JPanel();
        cfgTitlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        setLevelFileBtn = new javax.swing.JButton();
        cfgSaveLevelBtn = new javax.swing.JButton();
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setForeground(Theme.MAIN_FOREGROUND);
        jLabel5.setText("Current layer:");

        miscCurrentLayerLbl.setForeground(Theme.MAIN_FOREGROUND);
        miscCurrentLayerLbl.setText("<please selected a layer first>");

        renderPanel.setBackground(Theme.MAIN_ALT_BACKGROUND);
        renderPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.SEPARATOR));
        renderPanel.setLayout(new java.awt.BorderLayout());

        toolsPanel.setOpaque(false);

        toolsBtnGroup.add(toolSetSelectModeBtn);
        toolSetSelectModeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_cursor.png"))); // NOI18N
        toolSetSelectModeBtn.setSelected(true);
        toolSetSelectModeBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        toolSetSelectModeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolSetSelectModeBtnActionPerformed(evt);
            }
        });

        toolsBtnGroup.add(toolSetSpriteModeBtn);
        toolSetSpriteModeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aurelienribon/leveleditor/ui/gfx/ic_texture.png"))); // NOI18N
        toolSetSpriteModeBtn.setMargin(new java.awt.Insets(2, 5, 2, 5));
        toolSetSpriteModeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toolSetSpriteModeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout toolsPanelLayout = new javax.swing.GroupLayout(toolsPanel);
        toolsPanel.setLayout(toolsPanelLayout);
        toolsPanelLayout.setHorizontalGroup(
            toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolSetSelectModeBtn)
            .addComponent(toolSetSpriteModeBtn)
        );
        toolsPanelLayout.setVerticalGroup(
            toolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolsPanelLayout.createSequentialGroup()
                .addComponent(toolSetSelectModeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolSetSpriteModeBtn))
        );

        infoPanel.setBackground(Theme.MAIN_ALT_BACKGROUND);
        infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Theme.SEPARATOR));
        infoPanel.setLayout(new java.awt.CardLayout());
        infoPanel.add(dummyInfoPanel, "card2");

        javax.swing.GroupLayout renderPanelWrapperLayout = new javax.swing.GroupLayout(renderPanelWrapper);
        renderPanelWrapper.setLayout(renderPanelWrapperLayout);
        renderPanelWrapperLayout.setHorizontalGroup(
            renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(renderPanelWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(renderPanelWrapperLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(miscCurrentLayerLbl)
                        .addContainerGap(300, Short.MAX_VALUE))
                    .addGroup(renderPanelWrapperLayout.createSequentialGroup()
                        .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(renderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)))))
        );
        renderPanelWrapperLayout.setVerticalGroup(
            renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(renderPanelWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(miscCurrentLayerLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(renderPanelWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(renderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(setLevelFileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cfgSaveLevelBtn)
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
                    .addComponent(setLevelFileBtn)
                    .addComponent(cfgSaveLevelBtn))
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
                .addComponent(objManagerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
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

	private void toolSetSelectModeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSetSelectModeBtnActionPerformed
		AppManager.instance().setInteractionMode(AppManager.InteractionModes.SELECT);
		Component cmp = renderPanel.getComponent(0);
		if (cmp != null)
			cmp.requestFocusInWindow();
}//GEN-LAST:event_toolSetSelectModeBtnActionPerformed

	private void toolSetSpriteModeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toolSetSpriteModeBtnActionPerformed
		AppManager.instance().setInteractionMode(AppManager.InteractionModes.ADD_SPRITES);
		Component cmp = renderPanel.getComponent(0);
		if (cmp != null)
			cmp.requestFocusInWindow();
		if (AssetsManager.instance().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Consider adding some assets to the "
				+ "library to be able to place sprites.\n"
				+ "Just use the 'Manage assets' button.");
		}
}//GEN-LAST:event_toolSetSpriteModeBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cfgLevelFileField;
    private javax.swing.JButton cfgManageAssetsBtn;
    private javax.swing.JButton cfgSaveLevelBtn;
    private javax.swing.JPanel cfgTitlePanel;
    private javax.swing.JPanel configPanel;
    private aurelienribon.leveleditor.ui.infopanels.SelectModeInfoPanel dummyInfoPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoLbl;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel miscCurrentLayerLbl;
    private aurelienribon.leveleditor.ui.ManageObjectsPanel objManagerPanel;
    private javax.swing.JPanel objTitlePanel;
    private javax.swing.JPanel objectsPanel;
    private javax.swing.JPanel renderPanel;
    private javax.swing.JPanel renderPanelWrapper;
    private javax.swing.JButton setLevelFileBtn;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JToggleButton toolSetSelectModeBtn;
    private javax.swing.JToggleButton toolSetSpriteModeBtn;
    private javax.swing.ButtonGroup toolsBtnGroup;
    private javax.swing.JPanel toolsPanel;
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
