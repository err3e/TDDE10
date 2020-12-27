import java.util.ArrayList;

public class Location {

	private String name;
	private String description;
	private String shortDescription;
	private boolean hasBeenThere;
	private ArrayList<Item> items = new ArrayList<Item>();

	public Location(String name, String description, String shortDescription) {
		this.name = name;
		this.description = description;
		this.hasBeenThere = false;
		this.shortDescription = shortDescription;
	}

	public void addItem(Item i) {
		items.add(i);
	}

	public void beenThere() {
		hasBeenThere = true;
	}

	private Location[] paths = new Location[4];

	public String directionString(int direction) {
		if (direction == 0) {
			return ("north");
		}
		if (direction == 1) {
			return ("south");
		}
		if (direction == 2) {
			return ("west");
		} else {
			return ("east");
		}
	}

	public void addPath(Location north, Location south, Location west, Location east) {
		paths[0] = north;
		paths[1] = south;
		paths[2] = west;
		paths[3] = east;
	}

	public void printAvailablePaths() {

		for (int i = 0; i < 4; i++) {

			if (paths[i] != null) {

				if (this instanceof OutdoorsArea) {
					System.out
							.println("There is a road leading " + directionString(i) + " to the " + paths[i].getName());
				} else {
					System.out
							.println("There is a door leading " + directionString(i) + " to the " + paths[i].getName());
				}

			}
		}

	}

	public void doCommand(String com, Game game) {

		if (com.equals("north")) {
			if (paths[0] != null) {
				game.getPlayer().moveTo(paths[0]);

			} else {
				System.out.println("You can't go there!");
			}
		}

		if (com.equals("south")) {
			if (paths[1] != null) {
				game.getPlayer().moveTo(paths[1]);

			} else {
				System.out.println("You can't go there!");
			}
		}

		if (com.equals("west")) {
			if (paths[2] != null) {
				game.getPlayer().moveTo(paths[2]);

			} else {
				System.out.println("You can't go there!");
			}
		}

		if (com.equals("east")) {
			if (paths[3] != null) {
				game.getPlayer().moveTo(paths[3]);

			} else {
				System.out.println("You can't go there!");
			}
		}

		if (com.contentEquals("look")) {
			printAvailablePaths();
			printAvailableItems();
		}
	}

	public void printLocation() {
		if (hasBeenThere == false) {
			System.out.println("He is located in: ");
			System.out.println(name + description);
		} else {
			System.out.println("You are located in: ");
			System.out.println(name + shortDescription);
		}

		printAvailableItems();
	}

	public void printAvailableItems() {

		if (!items.isEmpty()) {
			System.out.println("Available item(s): ");
			for (Item i : items) {
				System.out.println("-----------------------------");
				i.printYourself();
				System.out.println("-----------------------------");
			}
		}
	}

	// Getters och setters.
	public ArrayList<Item> getItems() {
		return items;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

}
