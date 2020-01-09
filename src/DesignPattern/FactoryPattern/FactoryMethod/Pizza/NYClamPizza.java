package DesignPattern.FactoryPattern.FactoryMethod.Pizza;

public class NYClamPizza extends Pizza {
    public NYClamPizza() {
        name = "NY Style Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }

    @Override
    public void prepare() {
        System.out.println("NYClamPizza prepare");
    }

    @Override
    public void bake() {
        System.out.println("NYClamPizza bake");
    }

    @Override
    public void cut() {
        System.out.println("NYClamPizza cut");
    }

    @Override
    public void box() {
        System.out.println("NYClamPizza box");
    }
}
