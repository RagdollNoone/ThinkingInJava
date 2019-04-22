package DesignPattern.ObserverPattern;

public class SixthObserver implements Observer{
    public SixthObserver() {}

    public SixthObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject, Object args) {
        System.out.println("Sixth Observer Update");
    }
}
