package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.utils.ObservableList;
import aurelienribon.utils.ObservableListsHolder;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AssetsManager implements ObservableListsHolder {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final AssetsManager instance = new AssetsManager();
	public static AssetsManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Content
	// -------------------------------------------------------------------------

	private final ObservableList<AssetInfo> list = new ObservableList<AssetInfo>(this);

	public ObservableList<AssetInfo> getList() {
		return list;
	}

	// -------------------------------------------------------------------------
	// ObservableListsHolder impl.
	// -------------------------------------------------------------------------

	@Override
	public int getObservableListCount() {
		return 1;
	}

	@Override
	public ObservableList getObservableList(int idx) {
		return list;
	}
}
