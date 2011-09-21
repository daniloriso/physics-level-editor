package aurelienribon.leveleditor.ui;

import java.util.List;
import javax.swing.JPanel;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public abstract class InfoPanelChild extends JPanel {
	public abstract void setModels(List<Object> objs);
}
