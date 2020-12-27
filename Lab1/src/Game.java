import java.util.*;
import java.util.ArrayList;

public class Game {

	private Player player;
	private ArrayList<Location> world;

	public Game() {
		// skapar listan för världen (alla platser).
		world = new ArrayList<Location>(5);
		world.add(new OutdoorsArea("Mountains.",
				" You stand in awe as the great mountain loomed before you, cold grey crevices holding the blood of many battles. \n While the lower passes wore a cloak of greenery, the peaks were crowned with a headdress of ice.",
				" A beautiful place with lots of history.", "Cloudy")); // 0 North.
		world.add(new OutdoorsArea("Colloseum.",
				" Ancient building who carries an arena, many people have risk their lives here to entertain others.",
				" The ancient arena", "Rainy")); // 1 Centre.
		world.add(new OutdoorsArea("Forest.",
				" As you take a step closer to the frozen forest, goose bumps ran quickly through your spine. \n Your body was shivering as if you was in a living freezer. \n The trees were waving as you walk through the foot path.",
				" A cold place with trees.", "Snowy")); // 2 East.
		world.add(new Room("Drunk tavern.",
				" Feeling lonley? Visit the tavern to get drunk, meet some strangers and buy some company.",
				" The only way to have a good time.", 250)); // 3 South.
		world.add(new Room("Home.", " A warm and cozy place to feel safe, or is it?? :O ",
				" There is no place like home.", 40)); // 4 West.

		// lägger till items på de olika platserna.

		world.get(0).addItem(new Weapon(4.2, "Sword", 50, 7));
		world.get(4).addItem(new WearableItem(4.2, "Elven_robe", 50, 10));
		world.get(2).addItem(new WearableItem(4.2, "Clothes", 50, 0));

		// pekar de olika platserna mot de platser som ska gå att nå därifrån.
		world.get(0).addPath(null, world.get(1), null, null);
		world.get(1).addPath(world.get(0), world.get(3), world.get(4), world.get(2));
		world.get(2).addPath(null, null, world.get(1), null);
		world.get(3).addPath(world.get(1), null, null, null);
		world.get(4).addPath(null, null, null, world.get(1));
	}

	public void run() {
		System.out.println("Welcome to the adventure game!");
		System.out.println("What is your name?");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		// skapar spelaren och dess plats. Man får välja namn, men ej något annat.
		player = new Player(input, world.get(1));

		// player.addItem(new WearableItem(2.5, "Clothes", 50, 0));
		player.addItem(new Weapon(4.2, "Knife", 50, 3));
		player.addItem(new Shovel(10.5, "Shovel", 50));

		// test för att skriva ut spelaren.
		player.printPlayer();

		// måste skrivas ut från player eller location.
		player.getPosition().printLocation();
		player.getPosition().beenThere();

		// Förflyttar spelaren.

		// help
		System.out.println("Type: 'help' to access a list of commands!");

		while (true) {

			System.out.println("What do you want to do?");
			player.getPosition().printAvailablePaths();
			input = scanner.nextLine();

			// EXIT
			if (input.contentEquals("exit")) {
				System.out.println("Thank you for playing! See you next time.");
				break;
			}
			// HELP
			if (input.contentEquals("help")) {
				System.out.println("You will have 4 avalible paths at maximum and "
						+ "you move around with typing either 'east, west, north, south, "
						+ "with lower case letters.");
				System.out.println("Type: 'items' to view backpack." + "\nType: 'status' to view health and gold."
						+ "\nType: 'use + name of weapon' to use your weapons."
						+ "\nType: 'dig' to dig with your shovel."
						+ "\nType: 'wear + name of wearable item' to put on the item.");
			}

			// hanterar doCommands i olika klasser
			String[] splittedInput = input.split(" ");
			player.doCommand(splittedInput);

			// hanterar positioner
			player.getPosition().doCommand(input, this);
			player.getPosition().printLocation();
			player.getPosition().beenThere();
		}

	}

	// Getters och Setters.
	public Player getPlayer() {
		return player;
	}

	// Main
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}

}