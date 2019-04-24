package DesignPattern.FactoryPattern.AbstractFactory;

public abstract class PizzaStore {
    PizzaIngredientFactory factory = null;

    public PizzaStore() {}

    protected void setFactory(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    public abstract Pizza orderPizza(String type);
}
