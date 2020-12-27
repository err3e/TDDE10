package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.HighScore;
import Logic.Snek;

/* SouthPanel visar upp po�ngen, highscore och inneh�ller dessutom knappen f�r att komma till menyn*/
public class SouthPanel extends JPanel {
	private Snek snek = new Snek();
	private int score = snek.getScore();
	private JLabel highscore;
	private HighScore highScoreFile = new HighScore();
	JLabel currentScore;

	public SouthPanel() throws IOException {

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		currentScore = new JLabel();
		currentScore.setFont(new Font("Arial", 5, 20));
		currentScore.setForeground(new Color(0, 0, 150));
		this.add(currentScore);

		this.add(Box.createHorizontalStrut(100));
		highscore = new JLabel("Highscore: " + highScoreFile.HighScore());

		highscore.setFont(new Font("Arial", 5, 20));
		highscore.setForeground(new Color(0, 0, 150));
		this.add(highscore);
		this.add(Box.createHorizontalGlue());

	}

	// Getters och setters

	public void setScore(int score) {
		this.score = score;
	}

	public void setSnek(Snek snek) {
		this.snek = snek;
	}

	public JLabel getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(JLabel currentScore) {
		this.currentScore = currentScore;
	}

	public JLabel getHighscore() {
		return highscore;
	}
}
