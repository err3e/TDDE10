package Drawing;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

public class MyTriangleButton extends JComponent {

	private Color color;

	public MyTriangleButton(Color color) {
		
		this.color = color;

		this.setMinimumSize(new Dimension(40, 40));
		this.setMaximumSize(new Dimension(40, 40));
		this.setPreferredSize(new Dimension(40, 40));
		this.setSize(40, 40);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		
		int[] yPoints = new int[3];
		int nPoints = 3;
		int[] xPoints = new int[3];
		
		xPoints[0] = 0;
		xPoints[1] = 40;
		xPoints[2] = 20;
		
		yPoints[0] = 40;
		yPoints[1] = 40;
		yPoints[2] = 0;
		
		g.fillPolygon(xPoints, yPoints, nPoints);
	}	
}
