package DesignPattern.ObserverPattern;

import DesignPattern.ObserverPattern.TestCase1.DisplayElement;
import DesignPattern.ObserverPattern.TestCase2.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private float pressure;

    private ArrayList<Observer> observerArrayList;
    private DisplayElement.Tree<Observer> observerTree;
    private Queue<Node<Observer>> travelSupport;

    private boolean hasChanged = false;

    public WeatherData() {
        observerArrayList = new ArrayList<Observer>();
        travelSupport = new LinkedList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerArrayList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observerArrayList.indexOf(observer);
        observerArrayList.remove(index);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerArrayList.size(); i++) {
            observerArrayList.get(i).update(this, null);
        }
    }

    @Override
    public void notifyObserversTree() {
        if (null != observerTree) {
            travelSupport.add(observerTree.getRoot());

            while (travelSupport.size() != 0) {
                Node<Observer> currentTravelNode = travelSupport.poll();

                if (currentTravelNode.hasChildren()) {
                    List<Node<Observer>> currentChildren = currentTravelNode.getChildren();

                    for (int i = 0; i < currentChildren.size(); i++) {
                        travelSupport.add(currentChildren.get(i));
                    }
                }

                if (null != currentTravelNode.getData())
                    currentTravelNode.getData().update(this, null);
            }
        }

        observerTree = null;
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObservers();

        notifyObserversTree();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setHasChanged(boolean hasChanged) {
        this.hasChanged = hasChanged;
    }

    public boolean isHasChanged() {
        return hasChanged;
    }

    public void setObserverTree(DisplayElement.Tree<Observer> observerTree) {
        this.observerTree = observerTree;
    }
}
