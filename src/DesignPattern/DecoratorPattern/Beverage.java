package DesignPattern.DecoratorPattern;

public abstract class Beverage {
    private String description = "Unknow Beverage";

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract float cost();
}
