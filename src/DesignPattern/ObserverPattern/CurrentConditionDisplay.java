package DesignPattern.ObserverPattern;

public class CurrentConditionDisplay implements Observer, DisplayElement{
    private float temperature;
    private float humidty;

    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(Subject subject, Object args) {
        if (subject instanceof WeatherData) {
            this.temperature = weatherData.getTemperature();
            this.humidty = weatherData.getHumidity();

            display();
        }
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay temperature: " + temperature
                + " humidity: " + humidty);
    }
}
