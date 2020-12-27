package Drawing;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class EastPanel extends JComponent {
	
	private Model model;

	private Color red = new Color(255, 0, 0);
	private Color green = new Color(0, 255, 0);
	private Color blue = new Color(0, 0, 255);
	private Color yellow = new Color(255, 255, 0);
	private Color black = new Color(0, 0, 0);
	private Color orange = new Color(255, 120, 0);
	private Color pink = new Color(255, 0, 255);
	private Color cyan = new Color(0, 255, 255);

	public EastPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel form = new JLabel("F�rg");
		form.setAlignmentX(CENTER_ALIGNMENT);
		this.add(form);

		MySquareButton redButton = new MySquareButton(new Color(255, 0, 0));
		redButton.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, black));
		redButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentColor(red);
				setBorders(redButton, black);
			}
		});
		this.add(redButton);

		MySquareButton greenButton = new MySquareButton(green);
		greenButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentColor(green);
				setBorders(greenButton, black);
			}
		});
		this.add(greenButton);

		MySquareButton blueButton = new MySquareButton(blue);
		blueButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentColor(blue);
				setBorders(blueButton, black);
			}
		});
		this.add(blueButton);

		MySquareButton yellowButton = new MySquareButton(yellow);
		yellowButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentColor(yellow);
				setBorders(yellowButton, black);
			}
		});
		this.add(yellowButton);

		MySquareButton blackButton = new MySquareButton(new Color(0, 0, 0));
		blackButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentColor(new Color(0, 0, 0));
				setBorders(blackButton, new Color(255, 255, 255));
			}
		});
		this.add(blackButton);

		MySquareButton orangeButton = new MySquareButton(orange);
		orangeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentColor(orange);
				setBorders(orangeButton, black);
			}
		});
		this.add(orangeButton);

		MySquareButton pinkButton = new MySquareButton(pink);
		pinkButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentColor(pink);
				setBorders(pinkButton, black);
			}
		});
		this.add(pinkButton);

		MySquareButton cyanButton = new MySquareButton(cyan);
		cyanButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				model.setCurrentColor(cyan);
				setBorders(cyanButton, black);
			}
		});
		this.add(cyanButton);

		this.add(Box.createVerticalGlue());

		JLabel farg = new JLabel("Form");
		farg.setAlignmentX(CENTER_ALIGNMENT);
		this.add(farg);
	}

	public void setBorders(MySquareButton button, Color color) {
		for (int i = 1; i < getComponentCount() - 2; ++i) {
			((JComponent) getComponent(i)).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		button.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, color));
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
