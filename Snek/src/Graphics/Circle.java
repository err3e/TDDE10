package Graphics;

import java.awt.Color;
import java.awt.Graphics;

/* Circle är en subbklass till shape som lagrar en position och färg och ritar ut en cirkel med bestämd storlek*/
public class Circle extends Shape {

	private int size = 25;

	public Circle(int posX, int posY, Color color) {
		super(posX, posY, color);
	}

	@Override
	public void drawYourself(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(this.getPosX(), this.getPosY(), size, size);
	}
}
