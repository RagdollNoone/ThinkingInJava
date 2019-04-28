package DesignPattern.AdapterPattern;

public class MallardDuck implements Duck {
    @Override
    public void fly() {
        System.out.println("MallardDuck fly");
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck quack");
    }
}
