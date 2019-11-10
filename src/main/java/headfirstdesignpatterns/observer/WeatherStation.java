package headfirstdesignpatterns.observer;

public class WeatherStation {

    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(65f, 70f, 88f);


    }
}
