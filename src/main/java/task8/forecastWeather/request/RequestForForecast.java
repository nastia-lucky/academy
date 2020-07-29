package task8.forecastWeather.request;

import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestForForecast {

    private static final String BASE_URI = "http://api.openweathermap.org/data/2.5";
    private String parametrs = "onecall?";

    public RequestForForecast withCoordinates(Double latitude, Double longitude) {
        if (parametrs.endsWith("?")) {
            parametrs += String.format("lat=%s&lon=%s", latitude, longitude);
        }
        parametrs += String.format("&lat=%s&lon=%s", latitude, longitude);
        return this;
    }

    public RequestForForecast withApiId(String api) {
        parametrs += "&appid=" + api;
        return this;
    }

    public RequestForForecast withExclude(Excludes... exclude) {
        parametrs += "&exclude=" + exclude[0].name().toLowerCase();
        if (exclude.length > 1) {
            for (int i = 1; i < exclude.length; ++i) {
                parametrs += "," + exclude[i].name().toLowerCase();
            }
        }
        return this;
    }

    public Response doRequest() {
        return given()
                .log().all()
                .baseUri(BASE_URI)
                .request(Method.GET, parametrs);
    }

    public enum Excludes {
        CURRENT,
        MINUTELY,
        HOURLY,
        DAILY;
    }
}
