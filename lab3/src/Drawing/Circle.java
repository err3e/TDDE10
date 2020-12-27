package Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	private int size = 50;

	public Circle(int posX, int posY, Color color) {
		super(posX, posY, color);
	}

	@Override
	public void drawYourself(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(this.getPosX(), this.getPosY(), size, size);
	}
}
