package DesignPattern.DecoratorPattern.TestCase1.Size;

import DesignPattern.DecoratorPattern.TestCase1.Beverage;

import java.util.ArrayList;

public class Venti extends SizeDecorator {
    public Venti(Beverage beverage) {
        super("Venti", beverage);
    }

    @Override
    public float cost() {
        return this.beverage.cost() + 0.2f;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " Size Venti";
    }

    @Override
    public void getPrettyDescription(ArrayList<String> descriptionArrayList) {
        this.beverage.getPrettyDescription(descriptionArrayList);
        descriptionArrayList.add("Venti");
    }
}
