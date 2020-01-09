package DesignPattern.ObserverPattern.TestCase2;

import DesignPattern.ObserverPattern.Observer;
import DesignPattern.ObserverPattern.Subject;

public class FifthObserver implements Observer {
    public FifthObserver() {}

    public FifthObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject, Object args) {
        System.out.println("Fifth Observer Update");
    }
}
