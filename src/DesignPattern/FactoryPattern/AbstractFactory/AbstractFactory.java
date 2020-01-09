package DesignPattern.FactoryPattern.AbstractFactory;

import DesignPattern.FactoryPattern.AbstractFactory.Store.ChicagoPizzaStore;
import DesignPattern.FactoryPattern.AbstractFactory.Store.NYPizzaStore;
import DesignPattern.FactoryPattern.AbstractFactory.Store.PizzaStore;

public class AbstractFactory {
    public static void TestAbstractFactory(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("cheese");
        nyPizzaStore.orderPizza("clam");

        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        chicagoPizzaStore.orderPizza("cheese");
        chicagoPizzaStore.orderPizza("clam");
    }
}
