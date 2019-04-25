package DesignPattern.SingletonPattern;

public class HotterSingleton extends Singleton {
    protected static HotterSingleton instance;

    protected HotterSingleton() {
        super();
    }

    @Override
    public String toString() {
        return "HotterSingleton";
    }
}
