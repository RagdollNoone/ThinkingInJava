package DesignPattern.StrategyPattern;


public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();

        System.out.println("MallardDuck created");
    }

    @Override
    public void display() {
        System.out.println("MallardDuck display");
    }
}
