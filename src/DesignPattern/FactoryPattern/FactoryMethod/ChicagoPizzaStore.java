package DesignPattern.FactoryPattern.FactoryMethod;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new ChicagoCheesePizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoClamPizza();
        }

        return pizza;
    }
}
