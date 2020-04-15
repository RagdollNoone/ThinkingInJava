package DesignPattern;

import DesignPattern.AdapterPattern.AdapterPattern;
import DesignPattern.CommandPattern.CommandPattern;
import DesignPattern.FacadePattern.FacadePattern;
import DesignPattern.FactoryPattern.FactoryPattern;
import DesignPattern.SingletonPattern.SingletonPattern;
import DesignPattern.StrategyPattern.*;
import DesignPattern.ObserverPattern.*;
import DesignPattern.DecoratorPattern.*;


public class DesignPattern {
    public static void main(String[] args) {
        StrategyPattern.TestStrategyPattern(args);
        ObserverPattern.TestObserverPattern(args);
        DecoratorPattern.TestDecoratorPattern(args);
        FactoryPattern.TestFactoryPattern(args);
        SingletonPattern.TestSingletonPattern(args);
        CommandPattern.TestCommandPattern(args);
        AdapterPattern.TestAdapterPattern(args);
        FacadePattern.TestFacadePattern(args);

        // TemplateMethod Pattern
        // CaffeineBeverage tea = new Tea();
        // CaffeineBeverage coffee = new Coffee();
        // tea.prepareRecipe();
        // coffee.prepareRecipe();

        // Iterator Pattern
//        Waitress waitress = new Waitress();
//        waitress.printMenu();

        // State Pattern
        // GumballMachine gumballMachine = new GumballMachine(3);
        // gumballMachine.insertQuarter();
        // gumballMachine.insertQuarter();
        // gumballMachine.ejectQuarter();
        //
        // for (int i = 0; i < 3; i++) {
        //     gumballMachine.insertQuarter();
        //     gumballMachine.turnCrank();
        //     System.out.println("Count is " + gumballMachine.getCount());
        // }
        //
        // gumballMachine.insertQuarter();
        // gumballMachine.ejectQuarter();
        // gumballMachine.turnCrank();

        // Proxy Pattern
//        try {
//            VirtualProxy vp = new VirtualProxy();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        DynamicProxy dp = new DynamicProxy();
//        dp.drive();
    }
}
