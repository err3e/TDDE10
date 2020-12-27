package Animals;

public class Animal {
	private static int currentYear;
	public int age;
	public String name;
	public Animal friend;
	public Toy toy;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		
		return (Animal.currentYear-this.age);
	}
	
	public void setFriend (Animal friend) {
		this.friend = friend;
	}
	
	public void addToy (Toy toy) {
		this.toy = toy;
	}
	
	public static void setYear (int currentYear) {
		Animal.currentYear = currentYear;
	}
	public void introduceYourself() {
	System.out.println("Morr. Jag är ett djur som heter X.");
	System.out.println("Jag är " + this.age + " år gammal.");
	}

	public void print() {
		System.out.println(this.name + " med vännen " + this.friend.name + " och leksaken ");
		toy.print();
	}
}
