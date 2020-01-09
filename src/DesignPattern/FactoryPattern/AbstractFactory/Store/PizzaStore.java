package DesignPattern.FactoryPattern.AbstractFactory.Store;

import DesignPattern.FactoryPattern.AbstractFactory.Pizza.Pizza;
import DesignPattern.FactoryPattern.AbstractFactory.Factory.PizzaIngredientFactory;

public abstract class PizzaStore {
    PizzaIngredientFactory factory = null;

    public PizzaStore() {}

    protected void setFactory(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    public abstract Pizza orderPizza(String type);
}
