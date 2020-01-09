package DesignPattern.DecoratorPattern.TestCase1.Size;

import DesignPattern.DecoratorPattern.TestCase1.Beverage;

import java.util.ArrayList;

public class Tall extends SizeDecorator {
    public Tall(Beverage beverage) {
        super("Tall", beverage);
    }

    @Override
    public float cost() {
        return this.beverage.cost() + 0.3f;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " Size Tall";
    }

    @Override
    public void getPrettyDescription(ArrayList<String> descriptionArrayList) {
        this.beverage.getPrettyDescription(descriptionArrayList);
        descriptionArrayList.add("Tall");
    }
}
