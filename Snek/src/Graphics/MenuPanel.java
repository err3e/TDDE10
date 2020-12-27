package Graphics;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
/* MenuPanel �r f�nstret som visas n�r man startar spelet samt om man klickar p� knappen Menu i southPanel*/

public class MenuPanel extends JPanel {

	public MenuPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setVisible(false);
		this.setPreferredSize(new Dimension(1000, 1000));
	}

}
