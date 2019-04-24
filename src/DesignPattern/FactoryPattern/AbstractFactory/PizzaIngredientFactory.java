package DesignPattern.FactoryPattern.AbstractFactory;

public interface PizzaIngredientFactory {
    Sauce createSauce();
    Dough createDough();
}
