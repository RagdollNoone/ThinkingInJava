package DesignPattern.DecoratorPattern.TestCase1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Decorator extends Beverage {
    protected Beverage beverage;
    private static LinkedHashMap<String, Integer> prettyPrintSupportMap = new LinkedHashMap<>();

    public Decorator(String description, Beverage beverage) {
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
            if (entry.getKey().equals("Tall") || entry.getKey().equals("Venti") || entry.getKey().equals("Grande"))
                result = entry.getKey() + " " + result;
            else {
                result = result + entry.getValue() + " " + entry.getKey() + " ";
            }
        }

        return result;
    }

    // TODO: 写一个函数, 把Tall等size的形容词移动到具体咖啡名称的前面
}
