package aurelienribon.leveleditor.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AssetInfo {
	private final File file;
	private final BufferedImage img;
	private final int width;
	private final int height;
	private final int size;

	public AssetInfo(String path) {
		file = new File(path);
		size = (int) (file.length() / 1000L);

		BufferedImage tmp = null;
		try {
			tmp = ImageIO.read(file);
		} catch (IOException ex) {
		}

		if (tmp != null) {
			img = tmp;
			width = tmp.getWidth();
			height = tmp.getHeight();
		} else {
			img = null;
			width = -1;
			height = -1;
		}
	}

	public String getName() {
		return file.getName();
	}

	public String getPath() {
		return file.getPath();
	}

	public BufferedImage getImage() {
		return img;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getSize() {
		return size;
	}
}
