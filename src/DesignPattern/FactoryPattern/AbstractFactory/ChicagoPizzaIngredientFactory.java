package DesignPattern.FactoryPattern.AbstractFactory;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        Dough dough = new ThinCrustDough();
        System.out.println(dough.toString());
        return dough;
    }

    @Override
    public Sauce createSauce() {
        Sauce sauce = new PlumTomatoSauce();
        System.out.println(sauce.toString());
        return sauce;
    }
}
