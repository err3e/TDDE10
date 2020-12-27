package Logic;

import java.awt.Color;
import java.awt.Graphics;

/*Klassen enemy �r en abstrakt klass som styr hur enemies fungerar*/
public abstract class Enemy {

	private int posX;
	private int posY;
	private int size;
	private int health;
	private Color color;

	public Enemy(int posX, int posY, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
	}

	public abstract void drawYourself(Graphics g);

	public void wasHit() {
		health--;
		color = new Color(255, 0, 0);
	}

	public boolean isDead() {
		if (health == 0) {
			return true;
		}
		return false;
	}

	// Getters och setters
	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSize() {
		return size;
	}

	public Color getColor() {
		return color;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}
