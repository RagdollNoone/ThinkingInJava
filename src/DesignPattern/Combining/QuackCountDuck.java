package DesignPattern.Combining;

public class QuackCountDuck implements Quackable {
    private Quackable quackable;
    private static int quackCount;

    public QuackCountDuck(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        this.quackable.quack();
        quackCount++;
    }

    public static int getQuackCount() {
        return quackCount;
    }

    public static void cleanQuackCount() {
        quackCount = 0;
    }
}
