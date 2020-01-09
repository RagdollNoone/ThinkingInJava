package DesignPattern.FactoryPattern.AbstractFactory.Store;

import DesignPattern.FactoryPattern.AbstractFactory.Factory.ChicagoPizzaIngredientFactory;
import DesignPattern.FactoryPattern.AbstractFactory.Pizza.CheesePizza;
import DesignPattern.FactoryPattern.AbstractFactory.Pizza.ClamPizza;
import DesignPattern.FactoryPattern.AbstractFactory.Pizza.Pizza;
import DesignPattern.FactoryPattern.AbstractFactory.Factory.PizzaIngredientFactory;

public class ChicagoPizzaStore extends PizzaStore {
    public ChicagoPizzaStore() {
        PizzaIngredientFactory factory = new ChicagoPizzaIngredientFactory();
        setFactory(factory);
    }

    @Override
    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza("Chicago Cheese Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza("Chicago Clam Pizza");
        }

        System.out.println(pizza.getName());
        pizza.prepare(factory);
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
