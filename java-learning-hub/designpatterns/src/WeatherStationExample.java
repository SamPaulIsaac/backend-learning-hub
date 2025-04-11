import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherSubject {
    void addObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();
}

// Observer interface
interface WeatherObserver {
    void update(float temperature, float humidity, float pressure);
}

// Concrete subject class
class WeatherStation implements WeatherSubject {
    private final List<WeatherObserver> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}

// Concrete observer classes
class CurrentConditionsDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Current Conditions: Temperature = " + temperature +
                "F, Humidity = " + humidity + "%");
    }
}

class StatisticsDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Statistics: Temperature = " + temperature +
                "F, Humidity = " + humidity + "%");
    }
}

class ForecastDisplay implements WeatherObserver {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Forecast: Expect warmer weather with temperature = " +
                (temperature + 5) + "F and humidity = " + (humidity - 10) + "%");
    }
}

// Example usage
public class WeatherStationExample {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        // Register observers to the subject
        weatherStation.addObserver(currentConditionsDisplay);
        weatherStation.addObserver(statisticsDisplay);
        weatherStation.addObserver(forecastDisplay);

        // Simulate weather changes
        weatherStation.setMeasurements(75, 60, 30.4f);
        weatherStation.setMeasurements(80, 65, 29.2f);
        weatherStation.setMeasurements(78, 70, 29.9f);

        // Unregister an observer
        weatherStation.removeObserver(statisticsDisplay);

        // Simulate more weather changes
        weatherStation.setMeasurements(82, 75, 29.8f);
    }
}

