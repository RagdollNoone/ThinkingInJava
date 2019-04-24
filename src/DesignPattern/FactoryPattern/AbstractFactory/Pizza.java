package DesignPattern.FactoryPattern.AbstractFactory;

public abstract class Pizza {
    private String name;
    private Sauce sauce;
    private Dough dough;

    public Pizza() {}

    public Pizza(String name) {
        setName(name);
    }

    public void prepare(PizzaIngredientFactory factory) {
        System.out.println("Pizza preparing");
        sauce = factory.createSauce();
        dough = factory.createDough();
    }

    public void bake() {
        System.out.println("Pizza baking");
    }

    public void cut() {
        System.out.println("Pizza cutting");
    }

    public void box() {
        System.out.println("Pizza boxing");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
