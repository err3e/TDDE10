package Logic;

import java.awt.Color;
import Graphics.Circle;

/* Bullet �r sj�lva skottet man skjuter och �r en subbklass till cirkel som dessutom inneh�ller en best�md riktning �t vilken den f�rdas*/
public class Bullet extends Circle {

	private int xDirection = 0, yDirection = 0;

	public Bullet(int posX, int posY, Color color, int xDirection, int yDirection) {
		super(posX, posY, color);
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}

	public void move() {
		if (xDirection == 1) {
			int holder = this.getPosX();
			this.setPosX(holder + 25);
		}

		if (xDirection == -1) {
			int holder = this.getPosX();
			this.setPosX(holder - 25);
		}

		if (yDirection == -1) {
			int holder = this.getPosY();
			this.setPosY(holder - 25);
		}

		if (yDirection == 1) {
			int holder = this.getPosY();
			this.setPosY(holder + 25);
		}
	}
}
