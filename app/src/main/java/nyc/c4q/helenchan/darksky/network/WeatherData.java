package nyc.c4q.helenchan.darksky.network;

/**
 * Created by helenchan on 1/3/17.
 * "time": 1483430400,
 "summary": "Rain throughout the day and breezy starting in the afternoon.",
 "icon": "rain",
 "precipProbability": 0.71,
 "precipType": "rain",
 "temperatureMin": 47.86,
 "temperatureMax": 55.17,
 "humidity": 0.91,
 "windSpeed": 12.54,
 "windBearing": 175,
 "visibility": 5.82,
 "pressure": 1015.58,
 */


public class WeatherData {
    private String icon;
    private double temperatureMin;
    private double temperatureMax;
    private double precipProbability;

    public String getIcon() {
        return icon;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }
}
