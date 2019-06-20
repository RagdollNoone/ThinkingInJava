package DesignPattern.Combining;

public class DuckFactory extends abstractDuckFactory {
    @Override
    Quackable createRedheadDuck() {
        Quackable quackable = new RedheadDuck();
        return quackable;
    }

    @Override
    Quackable createDecoyDuck() {
        Quackable quackable = new DecoyDuck();
        return quackable;
    }

    @Override
    Quackable createGoose() {
        Quackable quackable = new GooseAdapter(new Goose());
        return quackable;
    }
}
