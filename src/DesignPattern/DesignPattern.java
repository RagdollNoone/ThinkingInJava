package DesignPattern;

import DesignPattern.DecoratorPattern.*;
import DesignPattern.ObserverPattern.CurrentConditionDisplay;
import DesignPattern.ObserverPattern.CurrentConditionDisplayObserver;
import DesignPattern.ObserverPattern.WeatherData;
import DesignPattern.ObserverPattern.WeatherDataObservable;

import java.util.ArrayList;

public class DesignPattern {
    public static void main(String[] args) {
//        Duck mallardDuck = new MallardDuck();
//        mallardDuck.performQuack();
//        mallardDuck.performFly();
//
//        Duck modelDuck = new ModelDuck();
//        modelDuck.performQuack();
//        modelDuck.performFly();
//
//        modelDuck.setQuackBehavior(new Squeak());
//        modelDuck.performQuack();


//        WeatherData weatherData = new WeatherData();
//        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
//        weatherData.setMeasurements(15, 20, 25);

//        WeatherDataObservable weatherDataObservable = new WeatherDataObservable();
//        CurrentConditionDisplayObserver currentConditionDisplayObserver = new CurrentConditionDisplayObserver(weatherDataObservable);
//        weatherDataObservable.setMeasurements(15, 20, 25);

        Beverage darkRoast = new DarkRoast();
        Beverage darkRoastWithMilk = new Milk(darkRoast);
        Beverage darkRoastWithDoubleMilk = new Milk(darkRoastWithMilk);
        Beverage darkRoastWithDoubleMilkAndMocha = new Mocha(darkRoastWithDoubleMilk);

        float cost = darkRoastWithDoubleMilkAndMocha.cost();
        String description = darkRoastWithDoubleMilkAndMocha.getDescription();

        System.out.println("cost value is " + cost);
        System.out.println("description is " + description);

        ArrayList<String> descriptionArrayList = new ArrayList<>();
        darkRoastWithDoubleMilkAndMocha.getPrettyDescription(descriptionArrayList);
        System.out.println(CondimentDecorator.printPrettyDescription(descriptionArrayList));
    }
}
