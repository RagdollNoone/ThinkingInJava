package DesignPattern;

import DesignPattern.AdapterPattern.*;
import DesignPattern.CommandPattern.*;
import DesignPattern.FacadePattern.Amplifier;
import DesignPattern.FacadePattern.DvdPlayer;
import DesignPattern.FacadePattern.HomeTheaterFacade;
import DesignPattern.FacadePattern.Screen;
import DesignPattern.FactoryPattern.AbstractFactory.ChicagoPizzaStore;
import DesignPattern.FactoryPattern.AbstractFactory.NYPizzaStore;
import DesignPattern.FactoryPattern.AbstractFactory.PizzaStore;
import DesignPattern.IteratorPattern.Waitress;
import DesignPattern.ProxyPattern.DynamicProxy.DynamicProxy;
import DesignPattern.ProxyPattern.VirtualProxy.VirtualProxy;
import DesignPattern.SingletonPattern.HotterSingleton;
import DesignPattern.SingletonPattern.Singleton;
import DesignPattern.TemplateMethodPattern.CaffeineBeverage;
import DesignPattern.TemplateMethodPattern.Coffee;
import DesignPattern.TemplateMethodPattern.Tea;

import DesignPattern.StatePattern.GumballMachine;

import javax.swing.*;
import java.util.ArrayList;

public class DesignPattern {
    public static void main(String[] args) {
        // Strategy Pattern
//        Duck mallardDuck = new MallardDuck();
//        mallardDuck.performQuack();
//        mallardDuck.performFly();
//
//        Duck modelDuck = new ModelDuck();
//        modelDuck.performQuack();
//        modelDuck.performFly();
//
//        modelDuck.setQuackBehavior(new Squeak());
//        modelDuck.performQuack();

        // Observer Pattern
//        WeatherData weatherData = new WeatherData();
//        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
//        weatherData.setMeasurements(15, 20, 25);

//        WeatherDataObservable weatherDataObservable = new WeatherDataObservable();
//        CurrentConditionDisplayObserver currentConditionDisplayObserver = new CurrentConditionDisplayObserver(weatherDataObservable);
//        weatherDataObservable.setMeasurements(15, 20, 25);

        // 有些时候 更新的逻辑有前驱后继的联系
        // 所以设计出一种按自定义层次的遍历更新方法是有必要的
//        WeatherData weatherData = new WeatherData();
//        Observer firstObserver = new FirstObserver();
//        Observer secondObserver = new SecondObserver();
//        Observer thirdObserver = new ThirdObserver();
//        Observer fourthObserver = new FourthObserver();
//        Observer fifthObserver = new FifthObserver();
//        Observer sixthObserver = new SixthObserver();
//        Observer seventhObserver = new SeventhObserver();
//
//        Tree<Observer> tree = new Tree<>(null);
//        Node<Observer> root =  tree.getRoot();
//
//        ArrayList<Node<Observer>> arrayListChildren1 = new ArrayList<>();
//        Node<Observer> firstObserverNode =  new Node(firstObserver);
//        arrayListChildren1.add(firstObserverNode);
//        arrayListChildren1.add(new Node(seventhObserver));
//        arrayListChildren1.add(new Node(fourthObserver));
//        root.setChildren(arrayListChildren1);
//
//        ArrayList<Node<Observer>> arrayListChildren2 = new ArrayList<>();
//        Node<Observer> secondObserverNode = new Node(secondObserver);
//        arrayListChildren2.add(secondObserverNode);
//        arrayListChildren2.add(new Node(sixthObserver));
//        firstObserverNode.setChildren(arrayListChildren2);
//
//        ArrayList<Node<Observer>> arrayListChildren3 = new ArrayList<>();
//        arrayListChildren3.add(new Node(thirdObserver));
//        arrayListChildren3.add(new Node(fifthObserver));
//        secondObserverNode.setChildren(arrayListChildren3);
//
//        weatherData.setObserverTree(tree);
//
//        weatherData.setMeasurements(15, 20, 25);

        // Decorator Pattern
//        Beverage darkRoast = new DarkRoast();
//        Beverage darkRoastWithMilk = new Milk(darkRoast);
//        Beverage darkRoastWithDoubleMilk = new Milk(darkRoastWithMilk);
//        Beverage darkRoastWithDoubleMilkAndMocha = new Mocha(darkRoastWithDoubleMilk);
//        Beverage darkRoastWithDoubleMilkAndMochaSizeTall = new Tall(darkRoastWithDoubleMilkAndMocha);
//
//        float cost = darkRoastWithDoubleMilkAndMochaSizeTall.cost();
//        String description = darkRoastWithDoubleMilkAndMochaSizeTall.getDescription();
//
//        System.out.println("cost value is " + cost);
//        System.out.println("description is " + description);
//
//        ArrayList<String> descriptionArrayList = new ArrayList<>();
//        darkRoastWithDoubleMilkAndMochaSizeTall.getPrettyDescription(descriptionArrayList);
//        System.out.println(CondimentDecorator.printPrettyDescription(descriptionArrayList));

//        int c;
//        try {
//            // TODO 工程目录研究下, 怎么添加resources目录
//            FileInputStream fs = new FileInputStream("resources/LowerCaseInputStream.txt");
//            BufferedInputStream bs = new BufferedInputStream(fs);
//            LowerCaseInputStream ls = new LowerCaseInputStream(bs);
//            InputStream in = new LowerCaseInputStream(ls);
//
//            while ((c = in.read()) >= 0) {
//                System.out.print((char)c);
//            }
//
//            in.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        // Factory Pattern
//        SimplePizzaFactory instance = SimplePizzaFactory.getInstance();
//        PizzaStoreForSimplePizzaFactory pizzaStoreForSimplePizzaFactory = new PizzaStoreForSimplePizzaFactory(instance);
//        pizzaStoreForSimplePizzaFactory.orderPizza("cheese");
//        pizzaStoreForSimplePizzaFactory.orderPizza("clam");

        // 这是个错误的示范
//        NYSimplePizzaFactory instance = (NYSimplePizzaFactory)SimplePizzaFactory.getInstance();
//        PizzaStoreForSimplePizzaFactory pizzaStoreForSimplePizzaFactory = new PizzaStoreForSimplePizzaFactory(instance);
//        pizzaStoreForSimplePizzaFactory.orderPizza("cheese");
//        pizzaStoreForSimplePizzaFactory.orderPizza("clam");

//        PizzaStore nyPizzaStore = new NYPizzaStore();
//        nyPizzaStore.orederPizza("cheese");
//        nyPizzaStore.orederPizza("clam");
//        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
//        chicagoPizzaStore.orederPizza("cheese");
//        chicagoPizzaStore.orederPizza("clam");

//        PizzaStore nyPizzaStore = new NYPizzaStore();
//        nyPizzaStore.orderPizza("cheese");
//        nyPizzaStore.orderPizza("clam");
//        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
//        chicagoPizzaStore.orderPizza("cheese");
//        chicagoPizzaStore.orderPizza("clam");

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

        DynamicProxy dp = new DynamicProxy();
        dp.drive();
    }
}
