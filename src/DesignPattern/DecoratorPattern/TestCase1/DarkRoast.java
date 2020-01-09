package DesignPattern.DecoratorPattern.TestCase1;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        super("DarkRoast");
    }

    @Override
    public float cost() {
        return 0.99f;
    }
}
