package Animals;

public class Dog extends Animal {
	
	public Dog (String name, int age) {
		super(name, age);
	}

	public void introduceYourself() {
		System.out.println("Vov!!! Jag är en hund som heter " + this.name + "!");
		System.out.println("Vov!!!");
		System.out.println("Jag är " + getAge() + " år gammal.");
	}
}
