package base.helpers;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import user.model.User;

import java.util.Map;

import static base.constant.BaseConstants.BENTEGO_TEST_API_URL;
import static io.restassured.RestAssured.given;

public class HttpClient {

    public static Response get(String path) {

        return given()
                .log().all()
                .baseUri(BENTEGO_TEST_API_URL)
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response get(String path, Map<String, ?> query) {

        return given()
                .log().all()
                .baseUri(BENTEGO_TEST_API_URL)
                .contentType(ContentType.JSON)
                .queryParams(query)
                .when()
                .get(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response post(String path, Object body)
    {
        return given()
                .log().all()
                .baseUri(BENTEGO_TEST_API_URL)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(path)
                .then()
                .log().body()
                .extract().response();
    }

    public static Response put(String path, Object body) {

        return given()
                .log().all()
                .baseUri(BENTEGO_TEST_API_URL)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .put(path)
                .then()
                .log().body()
                .extract().response();
    }
     public static Response delete(String path) {

        return given()
                .log().all()
                .baseUri(BENTEGO_TEST_API_URL)
                .contentType(ContentType.JSON)
                .when()
                .delete(path)
                .then()
                .log().body()
                .extract().response();
    }

}
