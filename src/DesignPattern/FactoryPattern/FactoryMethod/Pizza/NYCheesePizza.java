package DesignPattern.FactoryPattern.FactoryMethod.Pizza;

public class NYCheesePizza extends Pizza {
    public NYCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }

    @Override
    public void prepare() {
        System.out.println("NYCheesePizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("NYCheesePizza bake");
    }

    @Override
    public void cut() {
        System.out.println("NYCheesePizza cut");
    }

    @Override
    public void box() {
        System.out.println("NYCheesePizza box");
    }
}
