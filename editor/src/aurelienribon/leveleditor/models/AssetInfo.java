package aurelienribon.leveleditor.models;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public class AssetInfo {
	private final String name;
	private final String path;
	private final int width;
	private final int height;
	private final int fileSize;

	public AssetInfo(String name, String path, int width, int height, int fileSize) {
		this.name = name;
		this.path = path;
		this.width = width;
		this.height = height;
		this.fileSize = fileSize;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public float getSizeRatio() {
		return (float)width/(float)height;
	}

	public int getFileSize() {
		return fileSize;
	}
}
