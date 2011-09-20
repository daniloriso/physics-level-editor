package aurelienribon.leveleditor.ui.infopanels;

import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.leveleditor.ui.InfoPanelChild;
import aurelienribon.leveleditor.ui.Theme;
import aurelienribon.utils.ChangeListener;
import aurelienribon.utils.Changeable;
import java.util.Locale;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SelectModeSpriteInfoPanel extends javax.swing.JPanel implements InfoPanelChild {
	private SpriteModel model;

    public SelectModeSpriteInfoPanel() {
        initComponents();
    }

	@Override
	public void setModel(Changeable model) {
		this.model = (SpriteModel)model;
		model.addChangeListener(modelListener);
		update();
	}

	@Override
	public void dispose() {
		model.removeChangeListener(modelListener);
	}

	private final ChangeListener modelListener = new ChangeListener() {
		@Override public void propertyChanged(Object source, String propertyName) {
			update();
		}
	};

	private void update() {
		xField.setText(String.format(Locale.US, "%.2f", model.getX()));
		yField.setText(String.format(Locale.US, "%.2f", model.getY()));
		wField.setText(String.format(Locale.US, "%.2f", model.getWidth()));
		hField.setText(String.format(Locale.US, "%.2f", model.getHeight()));
		rField.setText(String.format(Locale.US, "%.2f", model.getRotation()));
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        xField = new javax.swing.JTextField();
        yField = new javax.swing.JTextField();
        hField = new javax.swing.JTextField();
        wField = new javax.swing.JTextField();
        rField = new javax.swing.JTextField();

        setBackground(Theme.MAIN_ALT_BACKGROUND);

        jLabel1.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel1.setText("x:");

        jLabel2.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel2.setText("y:");

        jLabel3.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel3.setText("height:");

        jLabel4.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel4.setText("width:");

        jLabel5.setForeground(Theme.MAIN_ALT_FOREGROUND);
        jLabel5.setText("rotation:");

        xField.setBackground(Theme.TEXTAREA_BACKGROUND);
        xField.setForeground(Theme.TEXTAREA_FOREGROUND);
        xField.setText("---");

        yField.setBackground(Theme.TEXTAREA_BACKGROUND);
        yField.setForeground(Theme.TEXTAREA_FOREGROUND);
        yField.setText("---");

        hField.setBackground(Theme.TEXTAREA_BACKGROUND);
        hField.setForeground(Theme.TEXTAREA_FOREGROUND);
        hField.setText("---");

        wField.setBackground(Theme.TEXTAREA_BACKGROUND);
        wField.setForeground(Theme.TEXTAREA_FOREGROUND);
        wField.setText("---");

        rField.setBackground(Theme.TEXTAREA_BACKGROUND);
        rField.setForeground(Theme.TEXTAREA_FOREGROUND);
        rField.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {hField, rField, wField, xField, yField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField rField;
    private javax.swing.JTextField wField;
    private javax.swing.JTextField xField;
    private javax.swing.JTextField yField;
    // End of variables declaration//GEN-END:variables

}
