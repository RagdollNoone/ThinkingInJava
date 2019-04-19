package DesignPattern.DecoratorPattern;

import java.util.ArrayList;

public abstract class Beverage {
    private String description = "Unknow Beverage";

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void getPrettyDescription(ArrayList<String> descriptionArrayList) {
        descriptionArrayList.add(description);
    }

    public abstract float cost();
}
