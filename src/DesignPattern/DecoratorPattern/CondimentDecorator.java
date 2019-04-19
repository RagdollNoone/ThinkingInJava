package DesignPattern.DecoratorPattern;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public CondimentDecorator(String description, Beverage beverage) {
        super(description);
        this.beverage = beverage;
    }

    @Override
    public abstract float cost();

    @Override
    public abstract String getDescription();
}
