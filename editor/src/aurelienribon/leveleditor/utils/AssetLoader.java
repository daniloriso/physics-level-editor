package aurelienribon.leveleditor.utils;

import aurelienribon.leveleditor.models.AssetInfo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public class AssetLoader {
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
		int length = (int) (file.length() / 1000L);
		AssetInfo info = new AssetInfo(file.name(), path, tex.getWidth(), tex.getHeight(), length);
		Texture.setEnforcePotImages(true);
		tex.dispose();
		return info;
	}

	public static BufferedImage getAssetImage(AssetInfo info) {
		try {
			return ImageIO.read(new File(info.getPath()));
		} catch (IOException ex) {}
		return null;
	}
}
