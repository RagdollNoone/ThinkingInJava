package DesignPattern.FactoryPattern.AbstractFactory.Factory;

import DesignPattern.FactoryPattern.AbstractFactory.Dough.Dough;
import DesignPattern.FactoryPattern.AbstractFactory.Dough.ThinCrustDough;
import DesignPattern.FactoryPattern.AbstractFactory.Sauce.PlumTomatoSauce;
import DesignPattern.FactoryPattern.AbstractFactory.Sauce.Sauce;

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
