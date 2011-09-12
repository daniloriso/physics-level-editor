package aurelienribon.utils;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public interface Changeable {
	public void addChangeListener(ChangeListener l);
	public void removeChangeListener(ChangeListener l);
}
