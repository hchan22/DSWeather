package nyc.c4q.helenchan.darksky;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.helenchan.darksky.network.Currently;
import nyc.c4q.helenchan.darksky.network.WeatherData;
import nyc.c4q.helenchan.darksky.network.WeatherResponse;
import nyc.c4q.helenchan.darksky.network.WeatherService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by helenchan on 1/3/17.
 */
public class WeatherFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    List<WeatherData> weatherList = new ArrayList<>();
    RecyclerView recyclerView;
    WeatherAdapter adapter;
    TextView currentTemp;
    TextView summary;
    ImageView iconImage;
    String icon;
    View root;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.weather_fragment, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerview_frag);
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new WeatherAdapter(weatherList));
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        currentTemp = (TextView) root.findViewById(R.id.currenttemp_tv);
        summary = (TextView) root.findViewById(R.id.summary_tv);
        iconImage = (ImageView) root.findViewById(R.id.image_icon);
        fetchWeather();
    }

    public void fetchWeather() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.darksky.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        Call<WeatherResponse> call = service.getWeather();
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "yay" + response.body());
                        Currently current = response.body().getCurrently();
                        currentTemp.setText(String.valueOf((int)current.getTemperature())+ (char) 0x00B0);
                        summary.setText(current.getSummary());
                        icon = current.getIcon();
                        setImage();
                        weatherList = response.body().getDaily().getData();
                        adapter = new WeatherAdapter(weatherList);
                        recyclerView.setAdapter(adapter);


                    } else {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());

            }
        });

    }

    public void setImage(){
        switch (icon) {
            case "rain":
            case "light rain":
            case "heavy rain":
            case "thunderstorm":
                Picasso.with(root.getContext())
                        .load(R.drawable.rain)
                        .into(iconImage);
                break;
            case "sunny":
            case "clear":
                Picasso.with(root.getContext())
                        .load(R.drawable.sunny)
                        .into(iconImage);
                break;
            case "cloudy":
                Picasso.with(root.getContext())
                        .load(R.drawable.cloud)
                        .into(iconImage);
                break;
            case "snow":
            case "light snow":
            case "heavy snow":
                Picasso.with(root.getContext())
                        .load(R.drawable.snow)
                        .into(iconImage);
                break;
            default:
                Picasso.with(root.getContext())
                        .load(R.drawable.cloudy)
                        .into(iconImage);

        }
    }

}
