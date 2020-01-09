package DesignPattern.FactoryPattern.FactoryMethod.Store;

import DesignPattern.FactoryPattern.FactoryMethod.Pizza.ChicagoCheesePizza;
import DesignPattern.FactoryPattern.FactoryMethod.Pizza.ChicagoClamPizza;
import DesignPattern.FactoryPattern.FactoryMethod.Pizza.Pizza;

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
