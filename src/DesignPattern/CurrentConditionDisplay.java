package DesignPattern;

public class CurrentConditionDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidty;

    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidty = humidity;

        display();
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay temperature: " + temperature
        + " humidity: " + humidty);
    }
}
