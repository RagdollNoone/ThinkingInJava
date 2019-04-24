package DesignPattern.DecoratorPattern;

import java.util.ArrayList;

public abstract class CondimentDecorator extends Decorator {
    public CondimentDecorator(String description, Beverage beverage) {
        super(description, beverage);
    }

    @Override
    public abstract float cost();

    @Override
    public abstract String getDescription();

    public abstract void getPrettyDescription(ArrayList<String> descriptionArrayList);
}