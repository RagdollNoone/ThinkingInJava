package DesignPattern.ObserverPattern;

import DesignPattern.ObserverPattern.TestCase1.CurrentConditionDisplay;
import DesignPattern.ObserverPattern.TestCase1.DisplayElement;
import DesignPattern.ObserverPattern.TestCase2.*;

import java.util.ArrayList;

public class ObserverPattern {
    public static void TestObserverPattern(String[] args) {
        System.out.println("Test ObserverPattern Result: ");
        TestCase1(args);
        System.out.println();
        TestCase2(args);
        System.out.println("############### END ###############");
        System.out.println();
    }

    private static void TestCase1(String[] args) {
        System.out.println("TestObserverPattern TestCase1 Result: ");
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(15, 20, 25);
        currentConditionDisplay.display();
    }

    private static void TestCase2(String[] args) {
        System.out.println("TestObserverPattern TestCase2 Result: ");
//         有些时候 更新的逻辑有前驱后继的联系
//         所以设计出一种按自定义层次的遍历更新方法是有必要的
        WeatherData weatherData = new WeatherData();
        Observer firstObserver = new FirstObserver();
        Observer secondObserver = new SecondObserver();
        Observer thirdObserver = new ThirdObserver();
        Observer fourthObserver = new FourthObserver();
        Observer fifthObserver = new FifthObserver();
        Observer sixthObserver = new SixthObserver();
        Observer seventhObserver = new SeventhObserver();

        DisplayElement.Tree<Observer> tree = new DisplayElement.Tree<>(null);
        Node<Observer> root =  tree.getRoot();

        ArrayList<Node<Observer>> arrayListChildren1 = new ArrayList<>();
        ArrayList<Node<Observer>> arrayListChildren2 = new ArrayList<>();
        ArrayList<Node<Observer>> arrayListChildren3 = new ArrayList<>();

        Node<Observer> firstObserverNode =  new Node(firstObserver);
        Node<Observer> secondObserverNode = new Node(secondObserver);

        arrayListChildren1.add(firstObserverNode);
        arrayListChildren1.add(new Node(seventhObserver));
        arrayListChildren1.add(new Node(fourthObserver));

        arrayListChildren2.add(secondObserverNode);
        arrayListChildren2.add(new Node(sixthObserver));

        arrayListChildren3.add(new Node(thirdObserver));
        arrayListChildren3.add(new Node(fifthObserver));

        secondObserverNode.setChildren(arrayListChildren3);
        firstObserverNode.setChildren(arrayListChildren2);
        root.setChildren(arrayListChildren1);

        weatherData.setObserverTree(tree);

        weatherData.setMeasurements(15, 20, 25);
    }
}
