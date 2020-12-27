package Logic;

import java.awt.Color;
import java.util.ArrayList;

import Graphics.Square;

/*Denna klass representerar sj�lva ormen*/
public class Snek {

	private int xDirection = 0;
	private int yDirection = 0;
	private Bullet bullet = null;
	private boolean onTheMove = false;
	private boolean hasPowerUp = false;
	private int positionX = 339;
	private int positionY = 340;
	private int score = 0;
	private boolean avoidCollision = false;
	private Color color = new Color(0, 0, 0);
	// private ArrayList<PowerUp> snekPowerUps = new ArrayList<PowerUp>();
	private ArrayList<Square> snekComponents = new ArrayList<Square>();
	private boolean map2 = false;;

	public Snek() {
		snekComponents.add(new Square(positionX, positionY, new Color(100, 100, 100)));
		snekComponents.add(new Square(positionX - 25, positionY, color));
		snekComponents.add(new Square(positionX - 50, positionY, color));
	}

	public boolean checkCollision(ArrayList<Enemy> enemies) {

		// Kollar om snek krockar med sig sj�lv
		if (!avoidCollision) {
			for (int i = 1; i < snekComponents.size(); ++i) {
				if (snekComponents.get(i).getPosX() == snekComponents.get(0).getPosX()
						&& snekComponents.get(i).getPosY() == snekComponents.get(0).getPosY()) {
					return true;
				}
			}
		}

		// Kollar om snek krockar med v�ggarna
		if (snekComponents.get(0).getPosX() > 764 || snekComponents.get(0).getPosX() < 189) {
			return true;
		} else if (snekComponents.get(0).getPosY() > 741 || snekComponents.get(0).getPosY() < 165) {
			return true;
		}

		if (map2) {
			for (int i = -4; i < 5; i++) {
				int posX = 489 + (i * 25);
				int posY = 465;
				if (snekComponents.get(0).getPosX() == posX && snekComponents.get(0).getPosY() == posY) {
					return true;
				}
			}
			for (int i = -4; i < 5; i++) {
				int posX = 489;
				int posY = 465 + (i * 25);
				if (snekComponents.get(0).getPosX() == posX && snekComponents.get(0).getPosY() == posY) {
					return true;
				}
			}
		}

		// Kollar om snek krockar med enemies

		for (int i = 0; i < enemies.size(); i++) {
			if (snekComponents.get(0).getPosX() == enemies.get(i).getPosX()
					&& snekComponents.get(0).getPosY() == enemies.get(i).getPosY()) {
				return true;
			}
		}

		return false;
	}

	public void addComponents() {
		snekComponents.add(new Square(snekComponents.get(snekComponents.size() - 1).getPosX(),
				snekComponents.get(snekComponents.size() - 1).getPosY(), color));
		score++;
	}

	public void createBullet() {

		Color bulletColor = new Color(255, 255, 0);
		if (xDirection == 1) {
			bullet = new Bullet(snekComponents.get(0).getPosX() + 25, snekComponents.get(0).getPosY(), bulletColor,
					xDirection, yDirection);
		}

		if (xDirection == -1) {
			bullet = new Bullet(snekComponents.get(0).getPosX() - 25, snekComponents.get(0).getPosY(), bulletColor,
					xDirection, yDirection);
		}

		if (yDirection == -1) {
			bullet = new Bullet(snekComponents.get(0).getPosX(), snekComponents.get(0).getPosY() - 25, bulletColor,
					xDirection, yDirection);
		}

		if (yDirection == 1) {
			bullet = new Bullet(snekComponents.get(0).getPosX(), snekComponents.get(0).getPosY() + 25, bulletColor,
					xDirection, yDirection);
		}
	}

	public void removeBullet() {
		bullet = null;
	}

	public boolean checkBulletExists() {
		if (bullet != null) {
			return true;
		}
		return false;
	}

	public boolean checkBulletCollision(ArrayList<Enemy> enemies) {

		// Kollar om bullet tr�ffar v�ggarna
		if (bullet.getPosX() > 764 || bullet.getPosX() < 189) {
			return true;
		} else if (bullet.getPosY() > 741 || bullet.getPosY() < 165) {
			return true;
		}

		if (map2) {
			for (int i = -4; i < 5; i++) {
				int posX = 489 + (i * 25);
				int posY = 465;
				if (bullet.getPosX() == posX && bullet.getPosY() == posY) {
					return true;
				}
			}

			for (int i = -4; i < 5; i++) {
				int posX = 489;
				int posY = 465 + (i * 25);
				if (bullet.getPosX() == posX && bullet.getPosY() == posY) {
					return true;
				}
			}
		}

		// Kollar om bullet tr�ffar enemies

		for (int i = 0; i < enemies.size(); i++) {
			if (bullet.getPosX() == enemies.get(i).getPosX() && bullet.getPosY() == enemies.get(i).getPosY()) {
				enemies.get(i).wasHit();
				if (enemies.get(i).isDead()) {
					enemies.remove(i);
				}
				return true;
			}
		}
		return false;

	}

	// Getters och setters
	public ArrayList<Square> getSnekComponents() {
		return snekComponents;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getLength() {
		return snekComponents.size();
	}

	public int getxDirection() {
		return xDirection;
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}

	public boolean isOnTheMove() {
		return onTheMove;
	}

	public void setOnTheMove(boolean onTheMove) {
		this.onTheMove = onTheMove;
	}

	public int getScore() {
		return score;
	}

	public boolean isAvoidCollision() {
		return avoidCollision;
	}

	public void setAvoidCollision(boolean avoidCollision) {
		this.avoidCollision = avoidCollision;
	}

	public boolean isHasPowerUp() {
		return hasPowerUp;
	}

	public void setHasPowerUp(boolean hasPowerUp) {
		this.hasPowerUp = hasPowerUp;
	}

	public Bullet getBullet() {
		return bullet;
	}

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}

	public boolean isMap2() {
		return map2;
	}

	public void setMap2(boolean map2) {
		this.map2 = map2;
	}

//	public ArrayList<PowerUp> getSnekPowerUps() {
//		return snekPowerUps;
//	}

//	public void setSnekPowerUps(ArrayList<PowerUp> snekPowerUps) {
//		this.snekPowerUps = snekPowerUps;
//	}
}
