package DesignPattern.DecoratorPattern;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super("Milk", beverage);
    }

    @Override
    public float cost() {
        return this.beverage.cost() + 0.1f;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " With Milk";
    }
}
