
public class WearableItem extends Item {

	private int addHealth;

	public WearableItem(double weight, String name, int price, int addHealth) {
		super(weight, name, price);
		this.addHealth = addHealth;
	}

	public boolean doCommand(String[] splittedInput, Player player) {
		if (splittedInput[0].contentEquals("wear") && splittedInput.length > 1) {

			if (this.getName().contentEquals(splittedInput[1])) {
				player.getWornItems().add((WearableItem) (this));
				player.changeHealth(((WearableItem) this).getAddHealth());
				System.out.println("You added: " + getAddHealth() + " health.");
				player.getInventoryItems().remove(this);
				return true;

			}
		}
		return false;

	}

	// Getters och Setters.
	public int getAddHealth() {
		return addHealth;
	}

}
