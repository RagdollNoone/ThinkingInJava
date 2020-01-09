package DesignPattern.ObserverPattern.TestCase2;

import DesignPattern.ObserverPattern.Observer;
import DesignPattern.ObserverPattern.Subject;

public class FirstObserver implements Observer {

    public FirstObserver() {}

    public FirstObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject, Object args) {
        System.out.println("First Observer Update");
    }
}
