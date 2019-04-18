package DesignPattern.StrategyPattern;

import DesignPattern.StrategyPattern.Duck;

public class ModelDuck extends Duck {
    public ModelDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();

        System.out.println("ModelDuck created");
    }

    @Override
    public void display() {
        System.out.println("ModelDuck display");
    }
}
