package aurelienribon.leveleditor.utils;

import aurelienribon.leveleditor.models.AssetInfo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class AssetLoader {
	private static final Map<AssetInfo, BufferedImage> imagesMap = new HashMap<AssetInfo, BufferedImage>();
	private static final Map<AssetInfo, TextureRegion> regionsMap = new HashMap<AssetInfo, TextureRegion>();
	private static final int[] potWidths = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 5096};

	/**
	 * Builds an AssetInfo from a file path.
	 * @param path
	 * @return
	 */
	public static AssetInfo getAssetInfo(String path) {
		try {
			path = new File(path).getCanonicalPath();
		} catch (IOException ex) {
			System.err.println("[error] Path '" + path + "' cannot be resolved.");
			return null;
		}

		FileHandle file = Gdx.files.absolute(path);
		if (!file.exists()) {
			System.err.println("[error] File '" + path + "' does not exist.");
			return null;
		}

		Texture.setEnforcePotImages(false);
		Texture tex = new Texture(file);
		Texture.setEnforcePotImages(true);
		int length = (int) (file.length() / 1000L);
		AssetInfo info = new AssetInfo(file.name(), path, tex.getWidth(), tex.getHeight(), length);
		tex.dispose();
		return info;
	}

	/**
	 * Returns a BufferedImage from an AssetInfo, or null if the asset does
	 * not exist or cannot be opened as a BufferedImage. The image is stored
	 * for future uses.
	 * @param info
	 * @return
	 */
	public static BufferedImage getAssetImage(AssetInfo info) {
		if (imagesMap.containsKey(info))
			return imagesMap.get(info);

		BufferedImage assetImage = null;
		try {
			assetImage = ImageIO.read(new File(info.getPath()));
			imagesMap.put(info, assetImage);
		} catch (IOException ex) {}
		return assetImage;
	}

	/**
	 * Builds a TextureRegion from an AssetInfo. The region is stored for
	 * future uses.
	 * @param info
	 * @return
	 */
	public static TextureRegion getAssetTexture(AssetInfo info) {
		if (regionsMap.containsKey(info))
			return regionsMap.get(info);

		Pixmap tempPm = new Pixmap(Gdx.files.absolute(info.getPath()));
		int origW = tempPm.getWidth();
		int origH = tempPm.getHeight();
		int w = getNearestPOT(origW);
		int h = getNearestPOT(origH);

		Pixmap assetPixmap = new Pixmap(w, h, tempPm.getFormat());
		assetPixmap.drawPixmap(tempPm, 0, 0, 0, 0, origW, origH);
		tempPm.dispose();

		Texture assetTexture = new Texture(assetPixmap);
		assetTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

		TextureRegion assetRegion = new TextureRegion(assetTexture, 0, 0, origW, origH);
		regionsMap.put(info, assetRegion);
		return assetRegion;
	}

	private static int getNearestPOT(int d) {
		for (int i=0; i<potWidths.length; i++)
			if (d <= potWidths[i])
				return potWidths[i];
		return -1;
	}
}
