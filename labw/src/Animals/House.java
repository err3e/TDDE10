package Animals;

import java.util.ArrayList;

public class House {

	private ArrayList<Animal> animals;
	
	public House () {
		animals = new ArrayList<Animal>();
	}
	
	public void addAnimal (Animal relation) {
	animals.add(relation);	
	}
	
	public void print() {
	    System.out.println("Följande djur finns i huset:");
	    
	    for (Animal animal : animals) {
	        animal.print();
	    }
	}
}
