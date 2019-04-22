package DesignPattern;

import DesignPattern.DecoratorPattern.*;
import DesignPattern.ObserverPattern.*;

import DesignPattern.ObserverPattern.Node;

import java.io.*;
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
        Beverage darkRoast = new DarkRoast();
        Beverage darkRoastWithMilk = new Milk(darkRoast);
        Beverage darkRoastWithDoubleMilk = new Milk(darkRoastWithMilk);
        Beverage darkRoastWithDoubleMilkAndMocha = new Mocha(darkRoastWithDoubleMilk);
        Beverage darkRoastWithDoubleMilkAndMochaSizeTall = new Tall(darkRoastWithDoubleMilkAndMocha);

        float cost = darkRoastWithDoubleMilkAndMochaSizeTall.cost();
        String description = darkRoastWithDoubleMilkAndMochaSizeTall.getDescription();

        System.out.println("cost value is " + cost);
        System.out.println("description is " + description);

        ArrayList<String> descriptionArrayList = new ArrayList<>();
        darkRoastWithDoubleMilkAndMochaSizeTall.getPrettyDescription(descriptionArrayList);
        System.out.println(CondimentDecorator.printPrettyDescription(descriptionArrayList));

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
    }
}
