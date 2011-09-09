package aurelienribon.leveleditor.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class LayerModel {
	private final List<AssetModel> assets = new ArrayList<AssetModel>();
	private String name;

	public LayerModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<AssetModel> getAssetsList() {
		return Collections.unmodifiableList(assets);
	}

	public int getAssetsCount() {
		return assets.size();
	}
}
