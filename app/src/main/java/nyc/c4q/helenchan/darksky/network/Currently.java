package nyc.c4q.helenchan.darksky.network;

/**
 * Created by helenchan on 12/29/16.

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
public class Currently {
    private long time;
    private String summary;
    private String icon;
    private double temperature;
    private double apparentTemperature;
    private double windSpeed;

    public long getTime() {
        return time;
    }

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }
}
