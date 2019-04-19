package DesignPattern.DecoratorPattern;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super("Mocha", beverage);
    }

    @Override
    public float cost() {
        return this.beverage.cost() + 0.2f;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " With Mocha";
    }
}
