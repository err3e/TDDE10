package Animals;

public class Cat extends Animal {

	public Cat(String name, int age) {
		super(name, age);
		
	}

	public void introduceYourself() {
		System.out.println("Mjau. Jag är en katt som heter " + this.name + ".");
		System.out.println("Jag är " + getAge() + " år gammal.");
	}

}
