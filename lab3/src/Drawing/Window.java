package Drawing;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

	private SouthPanel southPanel;
	private EastPanel eastPanel;
	private DrawPanel drawPanel;
	private Model model = new Model();

	public Window() {
		super("V�lkommen till ritprogrammet!");

		setLayout(new BorderLayout());

		southPanel = new SouthPanel();
		this.add(southPanel, BorderLayout.SOUTH);

		eastPanel = new EastPanel();
		eastPanel.setModel(model);
		ShapePanel shapePanel = new ShapePanel();
		shapePanel.setModel(model);
		eastPanel.add(shapePanel);
		this.add(eastPanel, BorderLayout.EAST);

		drawPanel = new DrawPanel();
		drawPanel.setModel(model);
		this.add(drawPanel, BorderLayout.CENTER);

		this.setSize(1000+eastPanel.getWidth(), 1000+southPanel.getHeight());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void createButtons() {

		final JButton clear = new JButton("Rensa");
		southPanel.add(clear);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clearModel();
				drawPanel.repaint();
			}
		});
	}
}
