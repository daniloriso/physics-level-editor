package aurelienribon.utils;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.WindowListener;
import javax.swing.SwingUtilities;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class SwingHelper {
	/**
	 * Adds a listener to the window parent of the given component. Can be
	 * before the component is really added to its hierachy.
	 * @param source The source component
	 * @param listener The listener to add to the window
	 */
	public static void addWindowListener(final Component source, final WindowListener listener) {
		if (source instanceof Window) {
			((Window)source).addWindowListener(listener);
		} else {
			source.addHierarchyListener(new HierarchyListener() {
				@Override public void hierarchyChanged(HierarchyEvent e) {
					if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) == HierarchyEvent.SHOWING_CHANGED) {
						SwingUtilities.getWindowAncestor(source).addWindowListener(listener);
					}
				}
			});
		}
	}
}
