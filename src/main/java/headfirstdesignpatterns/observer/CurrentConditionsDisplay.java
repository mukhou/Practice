package headfirstdesignpatterns.observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;//need this reference in case we have to remove this observer from the notify list

    public CurrentConditionsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        //register
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions are: " + temperature + humidity + pressure);

    }


}
