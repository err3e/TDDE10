package Drawing;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

public class ShapePanel extends JComponent {

	Model model;

	public ShapePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		MySquareButton squareButton = new MySquareButton(new Color(255, 255, 70));
		squareButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
		squareButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentShape(new Square(0, 0, new Color(0, 0, 0)));

				for (int i = 0; i < getComponentCount(); ++i) {
					((JComponent) getComponent(i)).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				}
				squareButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
			}
		});
		this.add(squareButton);

		MyCircleButton circleButton = new MyCircleButton(new Color(255, 255, 70));
		circleButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentShape(new Circle(0, 0, new Color(0, 0, 0)));

				for (int i = 0; i < getComponentCount(); ++i) {
					((JComponent) getComponent(i)).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				}
				circleButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
			}
		});
		this.add(circleButton);

		MyTriangleButton triangleButton = new MyTriangleButton(new Color(255, 255, 70));
		triangleButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentShape(new Triangle(0, 0, new Color(0, 0, 0)));

				for (int i = 0; i < getComponentCount(); ++i) {
					((JComponent) getComponent(i)).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				}
				triangleButton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0, 0, 0)));
			}
		});
		this.add(triangleButton);
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
