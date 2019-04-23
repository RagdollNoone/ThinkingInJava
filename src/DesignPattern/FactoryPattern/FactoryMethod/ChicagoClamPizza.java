package DesignPattern.FactoryPattern.FactoryMethod;

public class ChicagoClamPizza extends Pizza{
    public ChicagoClamPizza() {
        name = "Chicago Style Clam Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Frozen Clams from Chesapeake Bay");
    }

    @Override
    public void prepare() {
        System.out.println("ChicagoClamPizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("ChicagoClamPizza bake");
    }

    @Override
    public void cut() {
        System.out.println("ChicagoClamPizza cut");
    }

    @Override
    public void box() {
        System.out.println("ChicagoClamPizza box");
    }
}
