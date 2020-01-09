package DesignPattern.DecoratorPattern.TestCase1.Condiment;

import DesignPattern.DecoratorPattern.TestCase1.Beverage;
import java.util.ArrayList;

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

    @Override
    public void getPrettyDescription(ArrayList<String> descriptionArrayList) {
        this.beverage.getPrettyDescription(descriptionArrayList);
        descriptionArrayList.add("Mocha");
    }
}
