package DesignPattern.FactoryPattern.FactoryMethod;

public class PizzaStoreForSimplePizzaFactory {
    private SimplePizzaFactory simplePizzaFactory;

    public PizzaStoreForSimplePizzaFactory(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = simplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}
