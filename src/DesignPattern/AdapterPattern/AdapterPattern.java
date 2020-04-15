package DesignPattern.AdapterPattern;

public class AdapterPattern {
    public static void TestAdapterPattern(String[] args) {
        System.out.println("Test AdapterPattern Result: ");

        Duck mallardDuck = new MallardDuck();
        Turkey wildTurkey = new WildTurkey();

        DuckAdapter duckAdapter = new DuckAdapter(wildTurkey);
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(mallardDuck);

        duckAdapter.quack();
        duckAdapter.fly();

        turkeyAdapter.gobble();
        turkeyAdapter.fly();

        System.out.println("############### END ###############");
        System.out.println();
    }
}
