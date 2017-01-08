package nyc.c4q.helenchan.darksky.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by helenchan on 1/2/17.
 *40.7128, 74.0059
 * nyc
 * 37.8267,-122.4233
 * la
 */

public interface WeatherService {

    @GET("forecast/94ef1917e6c96b5a7055dc08a9d9bb0c/40.7389,-73.8786")
    Call<WeatherResponse> getWeather();
}
