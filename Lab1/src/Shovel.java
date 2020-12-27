
public class Shovel extends Tool {

	public Shovel(double weight, String name, int price) {
		super(weight, name, price);
	}

	@Override
	public boolean doCommand(String[] splittedInput, Player player) {
		if (splittedInput[0].contentEquals("dig")) {

			System.out.println("You dug a hole in the ground with the shovel but nothing was to be found");
		}
		return false;
	}
}
