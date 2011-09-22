package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.utils.ObservableList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AssetsManager {
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
}
