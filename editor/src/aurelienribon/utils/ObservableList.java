package aurelienribon.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.List;
import javax.swing.event.EventListenerList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public abstract class ObservableList<T> {
	private final List<T> children = new ArrayList<T>();

	public int size() {
		return children.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T get(int idx) {
		return children.get(idx);
	}

	public List<T> getAll() {
		return Collections.unmodifiableList(children);
	}

	public int indexOf(T elem) {
		return children.indexOf(elem);
	}

	public void add(T elem) {
		children.add(elem);
		fireElementAdded(indexOf(elem), elem);
	}

	public void add(int idx, T elem) {
		assert 0 <= idx && idx <= children.size();
		children.add(idx, elem);
		fireElementAdded(idx, elem);
	}

	public void remove(T elem) {
		assert children.contains(elem);
		int idx = indexOf(elem);
		children.remove(elem);
		fireElementRemoved(idx, elem);
	}

	public T remove(int idx) {
		assert 0 <= idx && idx < children.size();
		T elem = children.remove(idx);
		fireElementRemoved(idx, elem);
		return elem;
	}

	// -------------------------------------------------------------------------
	// Events
	// -------------------------------------------------------------------------

	private final EventListenerList listeners = new EventListenerList();

	public interface ListChangedListener<T> extends EventListener {
		public void elementAdded(Object source, int idx, T elem);
		public void elementRemoved(Object source, int idx, T elem);
	}

	public void addListChangedListener(ListChangedListener listener) {
		listeners.add(ListChangedListener.class, listener);
	}

	public void removeListChangedListener(ListChangedListener listener) {
		listeners.remove(ListChangedListener.class, listener);
	}

	private void fireElementAdded(int idx, T elem) {
		for (ListChangedListener listener : listeners.getListeners(ListChangedListener.class))
			listener.elementAdded(this, idx, elem);
	}

	private void fireElementRemoved(int idx, T elem) {
		for (ListChangedListener listener : listeners.getListeners(ListChangedListener.class))
			listener.elementRemoved(this, idx, elem);
	}
}
