package aurelienribon.leveleditor.ui;

import aurelienribon.utils.Changeable;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public interface InfoPanelChild {
	public void setModel(Changeable model);
	public void dispose();
}
