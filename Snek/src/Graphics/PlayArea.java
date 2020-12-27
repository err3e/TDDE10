package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

import Logic.Enemy;
import Logic.PowerUp;
import Logic.Snek;

/*Denna klass sk�ter utritningen av spelytan under spelets g�ng*/
public class PlayArea extends JPanel {

	private Snek snek = new Snek();
	private Circle food = new Circle(389, 390, new Color(0, 190, 0));
	private ArrayList<Enemy> enemies;
	private ArrayList<PowerUp> playAreaPowerUps;
	private boolean map2 = false;

	public PlayArea() {
		// repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		int posX = 5;
		int posY = 5;

		g.setColor(new Color(180, 230, 255));
		g.fillRect((this.getWidth() - 600) / 2, (this.getHeight() - 600) / 2, 600, 600);

		g.setColor(new Color(0, 0, 0));
		for (int i = 602; i <= 604; ++i) {
			g.drawRect((this.getWidth() - i) / 2, (this.getHeight() - i) / 2, i - 1, i - 1);
		}

		while (posY <= this.getHeight() - 25) {
			posX = 5;
			g.setColor(new Color(0, 0, 100));
			g.fillRect(posX, posY, 20, 20);

			posX = this.getWidth() - 25;
			g.setColor(new Color(0, 0, 100));
			g.fillRect(posX, posY, 20, 20);
			posY = posY + 25;
		}

		posY = 5;
		posX = 30;

		while (posX <= this.getWidth() - 30) {
			posY = 5;
			g.setColor(new Color(0, 0, 100));
			g.fillRect(posX, posY, 20, 20);

			posY = this.getHeight() - 25;
			g.setColor(new Color(0, 0, 100));
			g.fillRect(posX, posY, 20, 20);
			posX = posX + 25;
		}

		// Ritar ut sneks komponenter
		snek.getSnekComponents().forEach(Square -> Square.drawYourself(g));

		// Ritar ut sneks bullet
		if (snek.checkBulletExists()) {
			snek.getBullet().drawYourself(g);
		}

		// Ritar ut korset f�r bana 2
		if (map2) {
			for (int i = -4; i < 5; i++) {
				posX = 489 + (i * 25);
				posY = 465;

				g.setColor(new Color(0, 0, 0));
				g.fillRect(posX, posY, 25, 25);
			}

			for (int i = -4; i < 5; i++) {
				posX = 489;
				posY = 465 + (i * 25);

				g.setColor(new Color(0, 0, 0));
				g.fillRect(posX, posY, 25, 25);
			}
		}

		// Ritar ut enemies
		enemies.forEach(Enemy -> Enemy.drawYourself(g));

		// Ritar ut playAreas powerUps
		playAreaPowerUps.forEach(PowerUp -> PowerUp.drawYourself(g));

		// Ritar ut matbiten
		food.drawYourself(g);
	}

	public boolean checkFoodCollision() {
		if (snek.getSnekComponents().get(0).getPosX() == food.getPosX()
				&& snek.getSnekComponents().get(0).getPosY() == food.getPosY()) {
			return true;
		}
		return false;
	}

	// Getters och setters
	public Snek getSnek() {
		return snek;
	}

	public void setSnek(Snek snek) {
		this.snek = snek;
	}

	public Circle getFood() {
		return food;
	}

	public void setFood(Circle food) {
		this.food = food;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public void setPlayAreaPowerUps(ArrayList<PowerUp> playAreaPowerUps) {
		this.playAreaPowerUps = playAreaPowerUps;
	}

	public boolean isMap2() {
		return map2;
	}

	public void setMap2(boolean map2) {
		this.map2 = map2;
	}

}
