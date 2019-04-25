package DesignPattern.SingletonPattern;

public class Singleton {
    protected static Singleton instance;

    protected Singleton() {}

    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }

        return instance;
    }

    @Override
    public String toString() {
        return "Singleton";
    }
}
