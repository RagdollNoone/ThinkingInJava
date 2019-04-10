//: typeinfo/PetCount.java
// Using instanceof.
package Chapter11.exercise.Pet;

import java.util.*;

import static Common.Print.*;

public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);

            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);

        }
    }

    public static void
    countPets(PetCreator creator) {

        PetCounter counter = new PetCounter();

        for (Pet pet : creator.createArray(20)) {
            // List each individual pet:
            printnb(pet.getClass().getSimpleName() + " ");

            if (pet instanceof Cat)
                counter.count("Cat");

            if (pet instanceof Gerbil)
                counter.count("Gerbil");
        }

        // Show the counts:
        print();
        print(counter);
    }

    public static void main(String[] args) {
//      countPets(new ForNameCreator());
        countPets(new FactoryCreator());
    }

}
/* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pug=3, Cat=9, Hamster=1, Cymric=7, Mouse=2, Mutt=3, Rodent=5, Pet=20, Manx=7, EgyptianMau=7, Dog=6, Rat=2}
*///:~
