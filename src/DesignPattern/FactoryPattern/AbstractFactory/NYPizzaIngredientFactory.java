package DesignPattern.FactoryPattern.AbstractFactory;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        Dough dough = new ThickCrustDough();
        System.out.println(dough.toString());
        return dough;
    }

    @Override
    public Sauce createSauce() {
        Sauce sauce = new MarinaraSauce();
        System.out.println(sauce.toString());
        return sauce;
    }
}
