package DesignPattern;

import DesignPattern.StrategyPattern.*;

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


        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(15, 20, 25);
    }
}
