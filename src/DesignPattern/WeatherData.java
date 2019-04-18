package DesignPattern;


import java.util.ArrayList;

public class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private float pressure;

    private ArrayList<Observer> observerArrayList;

    public WeatherData() {
        observerArrayList = new ArrayList<Observer>();
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
            observerArrayList.get(i).update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    private void measurementsChanged() {
        notifyObservers();
    }
}
