package Chapter11.exercise.Pet;

public class Gerbil extends Pet {
    public Gerbil(String name) {
        super(name);
    }

    public Gerbil() {
        super();
    }

    public static class Factory
            implements Chapter11.exercise.Factory.Factory<Gerbil> {
        public Gerbil create() {
            return new Gerbil();
        }
    }
}
