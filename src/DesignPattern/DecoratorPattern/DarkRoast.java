package DesignPattern.DecoratorPattern;

public class DarkRoast extends Beverage{

    public DarkRoast() {
        super("DarkRoast");
    }

    @Override
    public float cost() {
        return 0.99f;
    }
}
