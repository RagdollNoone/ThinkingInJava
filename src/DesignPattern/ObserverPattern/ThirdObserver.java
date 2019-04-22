package DesignPattern.ObserverPattern;

public class ThirdObserver implements Observer {
    public ThirdObserver() {}

    public ThirdObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject, Object args) {
        System.out.println("Third Observer Update");

    }
}
