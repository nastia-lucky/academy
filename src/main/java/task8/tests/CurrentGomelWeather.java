package task8.tests;

import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import task8.currentWeather.CurrentWeatherData;
import task8.currentWeather.request.RequestForCurrentWeather;
import task8.listener.Listener;

@Listeners(Listener.class)
public class CurrentGomelWeather {

    private String cityName = "Gomel";
    private String expectedCountry = "BY";
    private String expectedDescription = "Clouds";
    private Double expectedLatitude = 52.42;
    private Double expectedLongitude = 31.01;

    @Test
    @Parameters("api")
    public void currentWeather(String api) {
        Response response = new RequestForCurrentWeather()
                .withCityName(cityName)
                .withApiId(api)
                .doRequest();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(response.as(CurrentWeatherData.class).getCountry(), expectedCountry,
                "The country doesn't coincide with expected");
        softassert.assertNotEquals(response.as(CurrentWeatherData.class).getWeatherDescription(), expectedDescription,
                "The weather doesn't coincide with expected");
        softassert.assertEquals(response.as(CurrentWeatherData.class).getLatitude(), expectedLatitude,
                "Latitude doesn't coincide with location");
        softassert.assertEquals(response.as(CurrentWeatherData.class).getLongitude(), expectedLongitude,
                "Longitude doesn't coincide with location");
        softassert.assertAll();
    }
}
