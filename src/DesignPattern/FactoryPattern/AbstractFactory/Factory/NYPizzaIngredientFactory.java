package DesignPattern.FactoryPattern.AbstractFactory.Factory;

import DesignPattern.FactoryPattern.AbstractFactory.Dough.Dough;
import DesignPattern.FactoryPattern.AbstractFactory.Dough.ThickCrustDough;
import DesignPattern.FactoryPattern.AbstractFactory.Sauce.MarinaraSauce;
import DesignPattern.FactoryPattern.AbstractFactory.Sauce.Sauce;

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
