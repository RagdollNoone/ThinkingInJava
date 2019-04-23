package DesignPattern.FactoryPattern.FactoryMethod;

public abstract class PizzaStore {
    public Pizza orederPizza(String type) {
        Pizza pizza = null;

        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
