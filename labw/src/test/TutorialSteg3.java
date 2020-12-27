package test;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;

public class TutorialSteg3 {

    public static void main(String[] args) {
        Animal.setYear(2019); // Så här anropar man en klassmetod,
                              // dvs en statisk metod.
                              // Hur ska koden för setYear se ut?
        
        Animal kurre = new Cat("Kurre", 6);
        Animal vilma = new Dog("Vilma", 3);
        
        kurre.introduceYourself();
        vilma.introduceYourself();

        Animal.setYear(2013); // Nu blir är ett nytt år för alla djur.

        kurre.introduceYourself();
        vilma.introduceYourself();
    }
}
