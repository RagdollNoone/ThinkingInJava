package DesignPattern.FactoryPattern;

import DesignPattern.FactoryPattern.AbstractFactory.AbstractFactory;
import DesignPattern.FactoryPattern.FactoryMethod.FactoryMethod;

public class FactoryPattern {
    public static void TestFactoryPattern(String[] args) {
        System.out.println("Test FactoryPattern Result: ");

        FactoryMethod.TestFactoryMethod(args);

        System.out.println();

        AbstractFactory.TestAbstractFactory(args);

        System.out.println("############### END ###############");
        System.out.println();
    }
}
