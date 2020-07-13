package task8.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import task8.currentWeather.RequestForCurrentWeather;

public class APITestWithoutApiKey {

    private String cityName = "Gomel";

    @Test
    public void withoutApiKeyTest() {
        Response response = new RequestForCurrentWeather().withCityName(cityName).doRequest();
        Assert.assertEquals(response.getStatusCode(), 401, "Response code is not equals 401");
    }
}
