package aurelienribon.utils;

import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface BaseTreeDataModel<T> {
	public List<ObservableList> getLists(T model);
}
