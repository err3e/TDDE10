package Logic;

import java.awt.Color;
import java.awt.Graphics;

/*Slowness �r en subbklass till powerUp som best�mmer hur l�ngsamt snek ska g� n�r den har plockat upp en s�dan power up*/
public class Slowness extends PowerUp {

	public Slowness(int posX, int posY, Color color) {
		super(posX, posY, color);
		this.setSize(25);
		this.setSlownessMultiplier(2);
	}

	@Override
	public void drawYourself(Graphics g) {
		g.setColor(this.getColor());
		g.fillOval(this.getPosX(), this.getPosY(), this.getSize(), this.getSize());
	}
}
