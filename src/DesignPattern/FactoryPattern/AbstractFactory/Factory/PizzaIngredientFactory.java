package DesignPattern.FactoryPattern.AbstractFactory.Factory;

import DesignPattern.FactoryPattern.AbstractFactory.Dough.Dough;
import DesignPattern.FactoryPattern.AbstractFactory.Sauce.Sauce;

public interface PizzaIngredientFactory {
    Sauce createSauce();
    Dough createDough();
}
