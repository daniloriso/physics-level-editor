package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.utils.ChangeableObject;
import aurelienribon.utils.ObservableList;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class TempSpriteManager extends ChangeableObject {
	// -------------------------------------------------------------------------
	// Singleton
	// -------------------------------------------------------------------------

	private static final TempSpriteManager instance = new TempSpriteManager();
	public static TempSpriteManager instance() {return instance;}

	// -------------------------------------------------------------------------
	// Content
	// -------------------------------------------------------------------------

	private SpriteModel tempSprite;

	public SpriteModel getTempSprite() {
		return tempSprite;
	}

	public void addSpriteToWorkingLayer() {
		if (tempSprite != null) {
			LayerModel layer = LayersManager.instance().getWorkingLayer();
			layer.getSprites().add(tempSprite);
			reload();
		}
	}

	public boolean reload() {
		ObservableList<AssetInfo> assets = AssetsManager.instance().getList();
		if (assets.isEmpty()) {
			tempSprite = null;
			firePropertyChanged("tempSprite");
			return true;
		} else if (tempSprite == null || !assets.contains(tempSprite.getAsset())) {
			tempSprite = createSprite(assets.get(0));
			firePropertyChanged("tempSprite");
			return true;
		} else {
			tempSprite = createSprite(tempSprite.getAsset());
			firePropertyChanged("tempSprite");
		}
		return false;
	}

	public void next() {
		ObservableList<AssetInfo> assets = AssetsManager.instance().getList();
		if (reload() == false) {
			int id = (assets.indexOf(tempSprite.getAsset())+1) % assets.size();
			tempSprite = createSprite(assets.get(id));
			firePropertyChanged("tempSprite");
		}
	}

	public void previous() {
		ObservableList<AssetInfo> assets = AssetsManager.instance().getList();
		if (reload() == false) {
			int id = (assets.indexOf(tempSprite.getAsset())-1) % assets.size();
			tempSprite = createSprite(assets.get(id));
			firePropertyChanged("tempSprite");
		}
	}

	private SpriteModel createSprite(AssetInfo asset) {
		assert asset != null;
		SpriteModel sprite = new SpriteModel(asset);
		sprite.setSize(asset.getWidth()/50f, asset.getHeight()/50f);
		return sprite;
	}
}
