package nyc.c4q.helenchan.darksky.network;

/**
 * Created by helenchan on 12/29/16.
 *
 * "latitude": 37.8267,
 "longitude": -122.4233,
 "timezone": "America/Los_Angeles",
 "offset": -8,
 "currently": {
 "time": 1483046685,
 "summary": "Clear",
 "icon": "clear-day",
 "nearestStormDistance": 224,
 "nearestStormBearing": 355,
 "precipIntensity": 0,
 "precipProbability": 0,
 "temperature": 56.23,
 "apparentTemperature": 56.23,
 "dewPoint": 42.69,
 "humidity": 0.6,
 "windSpeed": 10.48,
 "windBearing": 57,
 "visibility": 10,
 "cloudCover": 0.06,
 "pressure": 1022.02,
 "ozone": 266.54
 },
 */

public class WeatherResponse {
    private String timezone;
    private Currently currently;
    private Daily daily;

    public String getTimezone() {
        return timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public Daily getDaily() {
        return daily;
    }
}
