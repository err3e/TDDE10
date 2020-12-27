
public class Weapon extends Item {

	private int damage;

	public Weapon(double weight, String name, int price, int damage) {
		super(weight, name, price);
		this.damage = damage;
	}

	public void printYourself() {
		super.printYourself();
		System.out.println("Damage: " + damage);
	}

	public boolean doCommand(String[] splittedInput, Player player) {
		if (splittedInput[0].contentEquals("use")) {

			if (this.getName().contentEquals(splittedInput[1])) {
				System.out.println("There is nothing to attack!");
			}
		}
		return false;
	}
}
