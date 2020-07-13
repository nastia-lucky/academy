package task8.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import task8.currentWeather.CurrentWeatherData;
import task8.currentWeather.RequestForCurrentWeather;

public class CoincideWithCityTest {

    private Double longitude = 52.01;
    private Double latitude = 37.00;
    private String cityName = "Fereydūnkenār";

    @Test
    @Parameters("api")
    public void coincideWithTheCityTest(String api) {
        Response response = new RequestForCurrentWeather()
                .withCoordinates(latitude, longitude)
                .withApiId(api)
                .doRequest();
        Assert.assertEquals(response.as(CurrentWeatherData.class).getName(), cityName, "The country doesn't coincide with coordinate");
    }
}
