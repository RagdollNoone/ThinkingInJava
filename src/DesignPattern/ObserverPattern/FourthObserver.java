package DesignPattern.ObserverPattern;

public class FourthObserver implements Observer{
    public FourthObserver() {}

    public FourthObserver(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(Subject subject, Object args) {
        System.out.println("Fourth Observer Update");
    }
}
