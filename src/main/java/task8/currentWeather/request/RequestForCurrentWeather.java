package task8.currentWeather.request;

import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestForCurrentWeather {

    private static final String BASE_URI = "http://api.openweathermap.org/data/2.5";
    private String parametrs = "weather?";

    public RequestForCurrentWeather withCityName(String cityName) {
        if (parametrs.endsWith("?")) {
            parametrs += "q=" + cityName;
        }
        parametrs += "&q=" + cityName;
        return this;
    }

    public RequestForCurrentWeather withApiId(String api) {
        parametrs += "&appid=" + api;
        return this;
    }

    public RequestForCurrentWeather withCoordinates(Double latitude, Double longitude) {
        if (parametrs.endsWith("?")) {
            parametrs += String.format("lat=%s&lon=%s", latitude, longitude);
        }
        parametrs += String.format("&lat=%s&lon=%s", latitude, longitude);
        return this;
    }

    public Response doRequest() {
        return given()
                .log().all()
                .baseUri(BASE_URI)
                .request(Method.GET, parametrs);
    }
}
