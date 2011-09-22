package aurelienribon.leveleditor;

import aurelienribon.leveleditor.models.AssetInfo;
import aurelienribon.leveleditor.models.LayerModel;
import aurelienribon.leveleditor.models.SpriteModel;
import aurelienribon.utils.ChangeableObject;

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
		LayerModel layer = LayersManager.instance().getWorkingLayer();
		if (layer != null && tempSprite != null) {
			layer.add(tempSprite);
			reload();
		}
	}

	public boolean reload() {
		AssetsManager am = AssetsManager.instance();
		if (am.isEmpty()) {
			tempSprite = null;
			firePropertyChanged("tempSprite");
			return true;
		} else if (tempSprite == null || !am.contains(tempSprite.getAsset())) {
			tempSprite = createSprite(am.get(0));
			firePropertyChanged("tempSprite");
			return true;
		} else {
			tempSprite = createSprite(tempSprite.getAsset());
			firePropertyChanged("tempSprite");
		}
		return false;
	}

	public void next() {
		AssetsManager am = AssetsManager.instance();
		if (reload() == false) {
			int id = (am.indexOf(tempSprite.getAsset())+1) % am.size();
			tempSprite = createSprite(am.get(id));
			firePropertyChanged("tempSprite");
		}
	}

	public void previous() {
		AssetsManager am = AssetsManager.instance();
		if (reload() == false) {
			int id = (am.indexOf(tempSprite.getAsset())-1) % am.size();
			tempSprite = createSprite(am.get(id));
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
