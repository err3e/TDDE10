package Drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	private int size = 50;
		
	public Square(int posX, int posY, Color color) {
		super(posX, posY, color);
	}

	@Override
	public void drawYourself(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(this.getPosX(), this.getPosY(), size, size);
	}
}
