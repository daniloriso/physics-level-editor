package aurelienribon.leveleditor.models.behaviors;

/**
 * @author Aurelien Ribon | http://www.aurelienribon.com
 */
public interface Measurable extends Positionable {
	public float getWidth();
	public float getHeight();
	public float getRotation();
	public void setSize(float w, float h);
	public void setRotation(float r);
}
