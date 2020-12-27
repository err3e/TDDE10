package Drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

public class MySquareButton extends JComponent {

	private Color color;

	public MySquareButton(Color color) {

		this.color = color;

		this.setMinimumSize(new Dimension(40, 40));
		this.setMaximumSize(new Dimension(40, 40));
		this.setPreferredSize(new Dimension(40, 40));
		this.setSize(40, 40);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, 40, 40);
	}

}
