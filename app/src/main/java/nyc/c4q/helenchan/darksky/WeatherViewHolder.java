package nyc.c4q.helenchan.darksky;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.helenchan.darksky.network.WeatherData;

/**
 * Created by helenchan on 1/3/17.
 */
public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private TextView tempMin;
    private TextView tempMax;
    private TextView precipProbability;
    private TextView iconTV;
    private ImageView iconImage;
    private String icon;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        tempMin = (TextView) itemView.findViewById(R.id.temp_min_tv);
        tempMax = (TextView) itemView.findViewById(R.id.temp_max_tv);
        precipProbability = (TextView) itemView.findViewById(R.id.precip_prob_tv);
        iconTV = (TextView) itemView.findViewById(R.id.icon_textview);
        iconImage = (ImageView) itemView.findViewById(R.id.item_iv);

    }

    public void bind(WeatherData weatherData) {
        tempMin.setText("Min" + " " + String.valueOf((int) weatherData.getTemperatureMin()) + (char) 0x00B0);
        tempMax.setText("Max" + " " + String.valueOf((int) weatherData.getTemperatureMax()) + (char) 0x00B0);
        double prob = weatherData.getPrecipProbability();
        precipProbability.setText(String.valueOf((int)(prob * 100)) + "%");
        icon = weatherData.getIcon();
        iconTV.setText(icon);
        setImage();

    }

    public void setImage() {
        switch (icon) {
            case "rain":
            case "light rain":
            case "heavy rain":
            case "thunderstorm":
                Picasso.with(itemView.getContext())
                        .load(R.drawable.rain)
                        .into(iconImage);
                break;
            case "sunny":
            case "clear":
                Picasso.with(itemView.getContext())
                        .load(R.drawable.sunny)
                        .into(iconImage);
                break;
            case "cloudy":
                Picasso.with(itemView.getContext())
                        .load(R.drawable.cloud)
                        .into(iconImage);
                break;
            case "snow":
            case "light snow":
            case "heavy snow":
                Picasso.with(itemView.getContext())
                        .load(R.drawable.snow)
                        .into(iconImage);
                break;
            default:
                Picasso.with(itemView.getContext())
                        .load(R.drawable.cloudy)
                        .into(iconImage);

        }
    }
}