package DesignPattern.SingletonPattern;

public class Singleton {
    private static class SingleHolder {
        private static Singleton instance = new Singleton();
    }

    private Singleton() {}

    public Singleton getInstance() { return SingleHolder.instance; }

    @Override
    public String toString() {
        return "Singleton";
    }
}

//public class Singleton {
//    private volatile static Singleton instance;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (null == instance) {
//            synchronized (Singleton.class) {
//                if (null == instance) {
//                    instance = new Singleton();
//                }
//            }
//        }
//
//        return instance;
//    }
//
//    @Override
//    public String toString() {
//        return "Singleton";
//    }
//}

//public class Singleton {
//    private final static Singleton instance = new Singleton();
//
//    private Singleton() {}
//
//    public Singleton getInstance() { return instance; }
//}