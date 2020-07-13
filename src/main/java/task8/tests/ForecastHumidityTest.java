package task8.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.forecastWeather.DailyWeather;
import task8.forecastWeather.ForecastWeather;
import task8.forecastWeather.RequestForForecast;

import java.util.List;

public class ForecastHumidityTest {

    private Double longitude = 3.42;
    private Double latitude = 40.24;
    private Double expectedHumidity = 89.0;

    public static Double getMaxHumidity(List<DailyWeather> dailyWeatherList) {
        Double maxHumidity = 0.0;
        for (int i = 0; i < 5; ++i) {
            Double humidity = dailyWeatherList.get(i).getDailyHumidity();
            if (humidity > maxHumidity) {
                maxHumidity = humidity;
            }
        }
        return maxHumidity;
    }

    @Test
    @Parameters("api")
    public void forecastHumidityTest(String api) {
        Response response = new RequestForForecast()
                .withCoordinates(latitude, longitude)
                .withExclude(RequestForForecast.Excludes.MINUTELY, RequestForForecast.Excludes.HOURLY, RequestForForecast.Excludes.CURRENT)
                .withApiId(api)
                .doRequest();
        Assert.assertTrue(getMaxHumidity(response.as(ForecastWeather.class).getDailyWeather()) > expectedHumidity, "The humidity for 5 days is less than expected");
    }
}
