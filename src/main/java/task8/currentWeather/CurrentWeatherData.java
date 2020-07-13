package task8.currentWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherData {

    @JsonProperty("coord")
    private Coordinates coordinate;
    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("sys")
    private Location location;
    @JsonProperty("name")
    private String name;

    public String getWeatherDescription() {
        return weather.get(0).getMainDescription();
    }

    public Double getLongitude() {
        return coordinate.getLongitude();
    }

    public Double getLatitude() {
        return coordinate.getLatitude();
    }

    public String getCountry() {
        return location.getCountry();
    }

    public String getName() {
        return name;
    }
}
