package Logic;

import java.awt.Color;
import java.awt.Graphics;

/*Klassen powerUp �r en abstrakt klass som best�mmer hur powerups ska vara*/
public abstract class PowerUp {

	private int posX;
	private int posY;
	private int size;
	private int slownessMultiplier = 1;
	private boolean avoidCollision = false;

	private Color color;

	public PowerUp(int posX, int posY, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
	}

	public abstract void drawYourself(Graphics g);

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

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public int getSlownessMultiplier() {
		return slownessMultiplier;
	}

	public void setSlownessMultiplier(int slownessMultiplier) {
		this.slownessMultiplier = slownessMultiplier;
	}

	public boolean isAvoidCollision() {
		return avoidCollision;
	}

	public void setAvoidCollision(boolean avoidCollision) {
		this.avoidCollision = avoidCollision;
	}
}
