package Logic;

import java.awt.Color;
import java.awt.Graphics;

/*AvoidCollision �r en subbklass till powerUp som best�mmer att snek kan �ka igenom sig sj�lv utan att d� n�r den har plockat upp en s�dan power up*/
public class AvoidCollision extends PowerUp {

	public AvoidCollision(int posX, int posY, Color color) {
		super(posX, posY, color);
		this.setSize(25);
		this.setAvoidCollision(true);
	}

	public void drawYourself(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(this.getPosX(), this.getPosY(), this.getSize(), this.getSize());
	}

}
