package DesignPattern.FactoryPattern.AbstractFactory;

public class NYPizzaStore extends PizzaStore {
    public NYPizzaStore() {
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
        setFactory(factory);
    }

    @Override
    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza("NY Cheese Pizza");
        } else if (type.equals("clam")) {
            pizza = new ClamPizza("NY Clam Pizza");
        }

        System.out.println(pizza.getName());
        pizza.prepare(factory);
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
