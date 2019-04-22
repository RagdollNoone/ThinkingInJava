package DesignPattern.DecoratorPattern;

import java.util.ArrayList;

public class Grande extends SizeDecorator{
    public Grande(Beverage beverage) {
        super("Grande", beverage);
    }

    @Override
    public float cost() {
        return this.beverage.cost() + 0.1f;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " Size Grande";
    }

    @Override
    public void getPrettyDescription(ArrayList<String> descriptionArrayList) {
        this.beverage.getPrettyDescription(descriptionArrayList);
        descriptionArrayList.add("Grande");
    }
}
