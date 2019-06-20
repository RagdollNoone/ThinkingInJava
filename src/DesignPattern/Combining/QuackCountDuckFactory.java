package DesignPattern.Combining;

public class QuackCountDuckFactory extends abstractDuckFactory{
    @Override
    Quackable createDecoyDuck() {
        Quackable decoyDuck = new DecoyDuck();
        decoyDuck = new QuackCountDuck(decoyDuck);

        return decoyDuck;
    }

    @Override
    Quackable createRedheadDuck() {
        Quackable redheadDuck = new RedheadDuck();
        redheadDuck = new QuackCountDuck(redheadDuck);

        return redheadDuck;
    }

    @Override
    Quackable createGoose() {
        Quackable goose = new GooseAdapter(new Goose());
        goose = new QuackCountDuck(goose);

        return goose;
    }
}
