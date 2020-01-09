package DesignPattern.ObserverPattern.TestCase2;

import DesignPattern.ObserverPattern.Observer;
import DesignPattern.ObserverPattern.Subject;

public class SeventhObserver implements Observer {
    public SeventhObserver() {}

    public SeventhObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject, Object args) {
        System.out.println("Seventh Observer Update");
    }
}
