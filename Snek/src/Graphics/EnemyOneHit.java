package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import Logic.Enemy;

/*EnemyOneHit �r en subbklass till enemy och �r en typ av fiende som ser ut p� ett visst s�tt och har 1 liv */
public class EnemyOneHit extends Enemy {

	public EnemyOneHit(int posX, int posY, Color color) {
		super(posX, posY, color);
		this.setHealth(1);
	}

	@Override
	public void drawYourself(Graphics g) {
		g.setColor(this.getColor());

		int[] yPoints = new int[3];
		int nPoints = 3;
		int[] xPoints = new int[3];

		xPoints[0] = this.getPosX();
		xPoints[1] = this.getPosX() + 25;
		xPoints[2] = this.getPosX() + 12;

		yPoints[0] = this.getPosY() + 25;
		yPoints[1] = this.getPosY() + 25;
		yPoints[2] = this.getPosY();

		g.fillPolygon(xPoints, yPoints, nPoints);
	}
}
