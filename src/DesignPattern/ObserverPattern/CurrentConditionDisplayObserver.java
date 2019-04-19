package DesignPattern.ObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplayObserver implements Observer, DisplayElement {
    private Observable observable;

    private float temperature;
    private float humidty;

    public CurrentConditionDisplayObserver(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof WeatherDataObservable) {
            temperature = ((WeatherDataObservable) observable).getTemperature();
            humidty = ((WeatherDataObservable) observable).getHumidty();

            display();
        }
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay temperature: " + temperature
                + " humidity: " + humidty);
    }
}
