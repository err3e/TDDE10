package Graphics;

/* Shape �r en abstrakt klass som bet�mmer hur olika former ska bete sig*/
import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	private int posX;
	private int posY;
	private int size;
	private Color color;

	public Shape(int posX, int posY, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
	}

	public abstract void drawYourself(Graphics g);

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSize() {
		return size;
	}

	public Color getColor() {
		return color;
	}

}
