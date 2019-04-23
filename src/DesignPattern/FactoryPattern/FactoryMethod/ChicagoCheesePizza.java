package DesignPattern.FactoryPattern.FactoryMethod;

public class ChicagoCheesePizza extends Pizza{
    public ChicagoCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void prepare() {
        System.out.println("ChicagoCheesePizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("ChicagoCheesePizza bake");
    }

    @Override
    public void cut() {
        System.out.println("ChicagoCheesePizza cut");
    }

    @Override
    public void box() {
        System.out.println("ChicagoCheesePizza box");
    }
}
