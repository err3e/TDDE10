package Graphics;

/*Square �r en subbklass till shape och �r samma sak som cirkelklassen f�rutom att den ritar ut en kvadrat*/
import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {

	private int size = 25;

	public Square(int posX, int posY, Color color) {
		super(posX, posY, color);
	}

	@Override
	public void drawYourself(Graphics g) {
		g.setColor(this.getColor());
		g.fillRect(this.getPosX(), this.getPosY(), size, size);
	}
}
