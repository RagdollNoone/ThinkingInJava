package DesignPattern.FactoryPattern.FactoryMethod.Store;

import DesignPattern.FactoryPattern.FactoryMethod.Pizza.NYCheesePizza;
import DesignPattern.FactoryPattern.FactoryMethod.Pizza.NYClamPizza;
import DesignPattern.FactoryPattern.FactoryMethod.Pizza.Pizza;
import DesignPattern.FactoryPattern.FactoryMethod.Store.PizzaStore;

public class NYPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new NYCheesePizza();
        } else if (type.equals("clam")) {
            pizza = new NYClamPizza();
        }

        return pizza;
    }
}
