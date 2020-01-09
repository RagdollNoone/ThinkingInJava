package DesignPattern;

import DesignPattern.FactoryPattern.FactoryPattern;
import DesignPattern.StrategyPattern.*;
import DesignPattern.ObserverPattern.*;
import DesignPattern.DecoratorPattern.*;


public class DesignPattern {
    public static void main(String[] args) {
        StrategyPattern.TestStrategyPattern(args);
        ObserverPattern.TestObserverPattern(args);
        DecoratorPattern.TestDecoratorPattern(args);
        FactoryPattern.TestFactoryPattern(args);

        // Singleton Pattern
//        Singleton hotter = HotterSingleton.getInstance();
//        System.out.println(hotter.toString());

        // Command Pattern
//        RemoteControl remoteControl = new RemoteControl();
//        Light light = new Light();
//        CeilingFan ceilingFan = new CeilingFan();
//
//        Command lightOnCommand = new LightOnCommand(light);
//        Command lightOffCommand = new LightOffCommand(light);
//
//        Command ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
//        Command ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
//        Command ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
//        Command ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
//
//        Command[] commandsOn = {lightOnCommand, ceilingFanLowCommand, ceilingFanMediumCommand, ceilingFanHighCommand};
//        Command[] commandsOff = {ceilingFanMediumCommand, ceilingFanLowCommand, ceilingFanOffCommand, lightOffCommand};
//
//        Command macroCommandOn = new MacroCommand(commandsOn);
//        Command macroCommandOff = new MacroCommand(commandsOff);
//
//        remoteControl.setCommand((byte)0, macroCommandOn, macroCommandOff);
//
//        remoteControl.pressOn((byte)0);
//        remoteControl.pressUndo();
//        remoteControl.pressOn((byte)0);
//        remoteControl.pressOff((byte)0);
//        remoteControl.pressUndo();

        // Adapter Pattern
//        Duck mallardDuck = new MallardDuck();
//        Turkey wildTurkey = new WildTurkey();
//
//        DuckAdapter duckAdapter = new DuckAdapter(wildTurkey);
//        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(mallardDuck);
//
//        duckAdapter.quack();
//        duckAdapter.fly();
//
//        turkeyAdapter.gobble();
//        turkeyAdapter.fly();

        // Facade Pattern
//        Amplifier amplifier = new Amplifier();
//        DvdPlayer dvdPlayer = new DvdPlayer();
//        Screen screen = new Screen();
//
//        HomeTheaterFacade homeTheaterFacade =
//                new HomeTheaterFacade(amplifier,
//                        dvdPlayer, screen);
//
//        homeTheaterFacade.playMovie();
//        homeTheaterFacade.endMovie();

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
