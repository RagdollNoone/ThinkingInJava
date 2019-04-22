package DesignPattern.DecoratorPattern;

import java.util.ArrayList;

public abstract class SizeDecorator extends Decorator {
    public SizeDecorator(String description, Beverage beverage) {
        super(description, beverage);
    }

    // TODO: 如果大杯是中杯的1.25倍 小杯是中杯的0.75倍 佐料单算 该怎么实现?
    @Override
    public abstract float cost();

    @Override
    public abstract String getDescription();

    public abstract void getPrettyDescription(ArrayList<String> descriptionArrayList);
}