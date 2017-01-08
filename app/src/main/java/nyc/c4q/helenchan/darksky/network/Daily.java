package nyc.c4q.helenchan.darksky.network;

import java.util.List;

/**
 * Created by helenchan on 1/3/17.
 * "daily": {
 "summary": "Rain throughout the week, with temperatures bottoming out at 48°F on Friday.",
 "icon": "rain",
 "data": [{
 "time": 1483430400,
 "summary": "Rain throughout the day and breezy starting in the afternoon.",
 "icon": "rain",
 "precipIntensity": 0.0423,
 "precipIntensityMax": 0.1264,
 "precipIntensityMaxTime": 1483477200,
 "precipProbability": 0.71,
 "precipType": "rain",
 "temperatureMin": 47.86,
 "temperatureMinTime": 1483444800,
 "temperatureMax": 55.17,
 "temperatureMaxTime": 1483509600,
 "dewPoint": 48.57,
 "humidity": 0.91,
 "windSpeed": 12.54,
 "windBearing": 175,
 "visibility": 5.82,
 "cloudCover": 0.97,
 "pressure": 1015.58,
 "ozone": 298.41
 },
 *
 */

public class Daily {

    private List<WeatherData> data;

    public List<WeatherData> getData() {
        return data;
    }
}
