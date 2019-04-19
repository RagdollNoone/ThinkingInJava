package DesignPattern;

import DesignPattern.DecoratorPattern.Beverage;
import DesignPattern.DecoratorPattern.DarkRoast;
import DesignPattern.DecoratorPattern.Milk;
import DesignPattern.DecoratorPattern.Mocha;
import DesignPattern.ObserverPattern.CurrentConditionDisplay;
import DesignPattern.ObserverPattern.CurrentConditionDisplayObserver;
import DesignPattern.ObserverPattern.WeatherData;
import DesignPattern.ObserverPattern.WeatherDataObservable;

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
        Beverage darkRoastWithMilkAndMocha = new Mocha(darkRoastWithMilk);

        float cost = darkRoastWithMilkAndMocha.cost();
        String description = darkRoastWithMilkAndMocha.getDescription();

        System.out.println("cost value is " + cost);
        System.out.println("description is " + description);
    }
}
