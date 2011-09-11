package aurelienribon.utils;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public interface Changeable {
	public void addPropertyChangeListener(ChangeListener l);
	public void removePropertyChangeListener(ChangeListener l);
}
