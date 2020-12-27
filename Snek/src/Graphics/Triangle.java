package Graphics;

/*Triangle �r en subbklass till shape och g�r samma som cirkel fast den ritar ut en triangel*/
import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {

	public Triangle(int posX, int posY, Color color) {
		super(posX, posY, color);
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
