package DesignPattern.FactoryPattern;

import DesignPattern.FactoryPattern.AbstractFactory.AbstractFactory;
import DesignPattern.FactoryPattern.FactoryMethod.FactoryMethod;

public class FactoryPattern {
    public static void TestFactoryPattern(String[] args) {
        FactoryMethod.TestFactoryMethod(args);
        AbstractFactory.TestAbstractFactory(args);
    }
}
