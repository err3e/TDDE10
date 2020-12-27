package test;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Toy;
import Animals.House;

public class TutorialSteg4 {

	public static void main(String[] args) {
		// Sätt årtalet för djuren.
		Animal.setYear(2016);

		// Skapa några djur.
		Animal kurre = new Cat("Kurre", 6);
		Animal vilma = new Dog("Vilma", 3);
		Animal bamse = new Cat("Bamse", 12);
		Animal smilla = new Dog("Smilla", 1);

		// Skapa leksaker.
		Toy ball = new Toy("Boll");
		Toy shoe = new Toy("Tuggsko");
		Toy mouse = new Toy("Plastmus");

		// Skapa huset.
		House house = new House();

		// Skapa relationer mellan objekten.
		house.addAnimal(kurre);
		house.addAnimal(vilma);
		house.addAnimal(bamse);
		house.addAnimal(smilla);

		kurre.setFriend(vilma);
		vilma.setFriend(smilla);
		bamse.setFriend(kurre);

		kurre.addToy(ball);
		kurre.addToy(mouse);
		vilma.addToy(shoe);
		vilma.addToy(ball);

		// Skriv ut vad som finns i huset.
		house.print();
	}
}
