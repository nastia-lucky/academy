package task8.forecastWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyWeather {

    @JsonProperty("humidity")
    private Double humidity;

    public Double getDailyHumidity() {
        return humidity;
    }
}
