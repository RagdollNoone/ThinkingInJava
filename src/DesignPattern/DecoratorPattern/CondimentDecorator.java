package DesignPattern.DecoratorPattern;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;
    private static LinkedHashMap<String, Integer> prettyPrintSupportMap = new LinkedHashMap<>();

    public CondimentDecorator(String description, Beverage beverage) {
        super(description);
        this.beverage = beverage;
    }

    @Override
    public abstract float cost();

    @Override
    public abstract String getDescription();

    public abstract void getPrettyDescription(ArrayList<String> descriptionArrayList);

    public static String printPrettyDescription(ArrayList<String> descriptionArrayList) {
        prettyPrintSupportMap.clear();
        String result = "";

        for (int i = 0; i < descriptionArrayList.size(); i++) {
            String key = descriptionArrayList.get(i);

            if (prettyPrintSupportMap.containsKey(key)) {
                int oldValue = prettyPrintSupportMap.get(key);
                prettyPrintSupportMap.put(key, oldValue + 1);
            }
            else {
                prettyPrintSupportMap.put(key, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : prettyPrintSupportMap.entrySet()) {
            result = result + entry.getValue() + " " + entry.getKey() + " ";
        }

        return result;
    }
}
