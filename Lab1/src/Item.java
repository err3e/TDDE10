
public abstract class Item {
	private double weight;
	private String name;
	private int price;

	public Item(double weight, String name, int price) {
		this.weight = weight;
		this.name = name;
		this.price = price;
	}

	public void printYourself() {
		System.out.println(name + " (" + weight + " kg)");

	}

	public abstract boolean doCommand(String[] splittedInput, Player player);//String[] splittedInput, Player player) {
		//return false;


	// Getters och Setters.
	public String getName() {
		return name;
	}
}
