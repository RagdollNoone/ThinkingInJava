package DesignPattern.ObserverPattern;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

    void notifyObserversTree();
}
