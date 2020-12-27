import java.util.ArrayList;

public class Player {

	private String name;
	private Location position;
	private int gold;
	private int health;
	private ArrayList<Item> inventoryItems = new ArrayList<Item>();
	private ArrayList<WearableItem> wornItems = new ArrayList<WearableItem>();

	public Player(String name, Location position) {
		this.name = name;
		gold = 100;
		this.position = position;
		health = 9;
	}

	public void doCommand(String[] splittedInput) {

		// Plockar upp item
		if (splittedInput[0].equals("take")) {
			takeItem(splittedInput[1]);
		}

		// Skriver ut inventoryitems.
		if (splittedInput[0].equals("items")) {
			for (Item i : inventoryItems) {
				i.printYourself();
			}
		}

		// Skriver ut spelarens status (hp, gold etc.)
		if (splittedInput[0].contentEquals("status")) {
			printPlayer();
		}

		// skickar in varje inventory item i item.doCommand tillsammans med
		// splittedInput
		for (Item i : inventoryItems) {
			if (i.doCommand(splittedInput, this)) {
				break;
			}
		}
	}

	public void takeItem(String itemName) {
		if (!position.getItems().isEmpty()) {

			for (Item i : position.getItems()) {

				if (i.getName().equals(itemName)) {
					addItem(i);
					position.getItems().remove(i);
					System.out.println("You picked up the " + i.getName());
					break;
				}
			}
		} else {
			System.out.println("The item is not available to pick up!");
		}
	}

	public void addItem(Item i) {
		inventoryItems.add(i);
	}

	public void printPlayer() {
		System.out.println("Your players name: " + name + ". He has: " + gold + " Gold, and " + health + " Health.");
	}

	public void changeGold(int newGold) {
		this.gold = gold + newGold;
	}

	public void changeHealth(int newHealth) {
		health = health + newHealth;
	}

	public void moveTo(Location newPosition) {
		position = newPosition;
	}

	// Getters och setters.
	public Location getPosition() {
		return position;
	}

	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

	public ArrayList<WearableItem> getWornItems() {
		return wornItems;
	}
}