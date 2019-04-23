package DesignPattern.FactoryPattern.FactoryMethod;

public class SimplePizzaFactory {
    // 如果设计成这种单例模式, 这个类就不适合被继承
    // 应为无法享用多态的特性
    private static class SimplePizzaFactoryHolder {
        private static SimplePizzaFactory INSTANCE = new SimplePizzaFactory();
    }

    public static SimplePizzaFactory getInstance() {
        return SimplePizzaFactoryHolder.INSTANCE;
    }

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        }

        return pizza;
    }
}
