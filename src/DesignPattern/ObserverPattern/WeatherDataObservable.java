package DesignPattern.ObserverPattern;

import java.util.Observable;

public class WeatherDataObservable extends Observable{
    private float temperature;
    private float humidty;
    private float pressure;

    public void setMeasurements(float temperature, float humidty, float pressure) {
        this.temperature = temperature;
        this.humidty = humidty;
        this.pressure = pressure;

        setChanged();

        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidty() {
        return humidty;
    }

    public float getPressure() {
        return pressure;
    }
}
