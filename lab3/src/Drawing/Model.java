package Drawing;

import java.awt.Color;
import java.util.ArrayList;

public class Model {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Color currentColor = new Color(255, 0, 0);
	private Shape currentShape = new Square(0, 0, currentColor);

	public Model() {

	}

	public void clearModel() {
		shapes = new ArrayList<Shape>();
	}

	public void createShape(int posX, int posY) {

		if (currentShape instanceof Square) {
			Shape square = new Square(posX, posY, currentColor);
			shapes.add(square);
		} else if (currentShape instanceof Circle) {
			Shape circle = new Circle(posX, posY, currentColor);
			shapes.add(circle);
		} else if (currentShape instanceof Triangle) {
			Shape triangle = new Triangle(posX, posY, currentColor);
			shapes.add(triangle);
		}
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
	}

	public void setCurrentShape(Shape currentShape) {
		this.currentShape = currentShape;
	}

	public boolean shapesIsEmpty() {
		// Kommentar: Istället för if-satsen kan man göra return shapes.size() == 0;
		// Här kan man till och med göra return shapes.isEmpty();
		if (shapes.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
