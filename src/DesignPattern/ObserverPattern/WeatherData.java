package DesignPattern.ObserverPattern;


import java.util.ArrayList;

public class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private float pressure;

    private ArrayList<Observer> observerArrayList;

    private boolean hasChanged = false;

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
            observerArrayList.get(i).update(this, null);
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
}
