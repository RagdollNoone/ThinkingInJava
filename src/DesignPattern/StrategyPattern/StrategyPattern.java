package DesignPattern.StrategyPattern;


public class StrategyPattern {
    public static void TestStrategyPattern(String[] arggs) {
        System.out.println("Test StrategyPattern Result: ");

        Duck mallardDuck = new MallardDuck();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        Duck modelDuck = new ModelDuck();
        modelDuck.performQuack();
        modelDuck.performFly();

        modelDuck.setQuackBehavior(new Squeak());
        modelDuck.performQuack();
        System.out.println("############### END ###############");
        System.out.println();
    }
}
