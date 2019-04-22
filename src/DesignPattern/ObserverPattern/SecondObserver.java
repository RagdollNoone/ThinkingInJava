package DesignPattern.ObserverPattern;

public class SecondObserver implements Observer {
    public SecondObserver() {}

    public SecondObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject, Object args) {
        System.out.println("Second Observer Update");
    }
}
