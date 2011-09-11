package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.utils.ObservableList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AssetsManager extends ObservableList<AssetInfo> {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final AssetsManager instance = new AssetsManager();
	public static AssetsManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Content
	// -------------------------------------------------------------------------
}
