
public class Room extends Location {

	private int size;

	public Room(String name, String description, String shortDescription, int size) {
		super(name, description, shortDescription);
		this.size = size;
	}

	public void printLocation() {
		super.printLocation();
		System.out.println("The size of the room is " + size + " square meters big.");
	}
}
