package DesignPattern.FactoryPattern.FactoryMethod;

import DesignPattern.FactoryPattern.FactoryMethod.Store.ChicagoPizzaStore;
import DesignPattern.FactoryPattern.FactoryMethod.Store.NYPizzaStore;
import DesignPattern.FactoryPattern.FactoryMethod.Store.PizzaStore;

public class FactoryMethod {
    public static void TestFactoryMethod(String[] args) {
        System.out.println("TestFactoryPattern TestFactoryMethod Result: ");
        PizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("cheese");
        nyPizzaStore.orderPizza("clam");

        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        chicagoPizzaStore.orderPizza("cheese");
        chicagoPizzaStore.orderPizza("clam");
    }
}
