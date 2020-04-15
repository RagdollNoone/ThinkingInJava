package DesignPattern.SingletonPattern;

public class SingletonPattern {
    public static void TestSingletonPattern(String[] args) {
        System.out.println("Test SingletonPattern Result: ");

        // Singleton Pattern
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.toString());

        System.out.println("############### END ###############");
        System.out.println();
    }
}
