package Chapter11.exercise.Pet;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }

    public static class Factory
            implements Chapter11.exercise.Factory.Factory<Cat> {
        public Cat create() {
            return new Cat();
        }
    }
} ///:~
