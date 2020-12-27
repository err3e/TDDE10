package Drawing;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawPanel extends JPanel {

	private Model model;

	public DrawPanel() {
		this.setBackground(new Color(255, 255, 245));

		this.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				model.createShape(e.getX() - 25, e.getY() - 25);
				repaint();
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		model.getShapes().forEach(shape -> shape.drawYourself(g));
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
