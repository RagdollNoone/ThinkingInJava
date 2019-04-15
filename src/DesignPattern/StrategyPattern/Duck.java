package DesignPattern.StrategyPattern;

public abstract class Duck {
    public abstract void display();
    public void swim() { System.out.println("Swim"); }

    public void performQuack() { quackBehavior.quack(); }
    public void performFly() { flyBehavior.fly(); }

    // 为了动态的改变对象的行为
    public void setQuackBehavior(QuackBehavior behavior) { quackBehavior = behavior; }
    public void setFlyBehavior(FlyBehavior behavior) { flyBehavior = behavior; }

    public QuackBehavior quackBehavior;
    public FlyBehavior flyBehavior;
}
