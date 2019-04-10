package Chapter11.exercise.Pet;

import java.util.*;

import Chapter11.exercise.Factory.Factory;

public class FactoryCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    static {
        types.add(Cat.class);
        types.add(Gerbil.class);
    }

    public List<Class<? extends Pet>> types() {
        return types;
    }

    static List<Factory<? extends Pet>> petFactories = new ArrayList<>();

    static {
        petFactories.add(new Cat.Factory());
        petFactories.add(new Gerbil.Factory());
    }

    private static Random rand = new Random(47);

    public Pet randomPet() {
        int n = rand.nextInt(petFactories.size());
        return petFactories.get(n).create();
    }
}
