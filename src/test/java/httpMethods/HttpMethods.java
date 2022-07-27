package httpMethods;

import base.helpers.HttpClient;
import base.helpers.Verify;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import user.model.User;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HttpMethods {


    protected  String userPath = "user/";
    String userName = "ozcana";

    private final User request = User.builder()
            .id(1)
            .username(userName)
            .lastName("arpaci")
            .email("ozcan@gmail.com")
            .password("1234567")
            .phone("5451111111")
            .userStatus(0)
            .build();


    @Test
    @Order(1)
    public void post() {
        request.setFirstName("özcan");
        Response response = HttpClient.post(userPath, request);
        Assertions.assertEquals(200, response.statusCode(), "Status codes are not match");
        //Normalde post başarılı işleminde  201 döner fakat burada 200 dönüyor. Testi buna göre ayarladım
    }

    @Test
    @Order(2)
    public void get() {

        Response response = HttpClient.get(userPath + userName);

        Verify.statusCode(response, 200);
        Verify.schemaVerify(response, "userInfo.json");
        Assertions.assertEquals(1, (Integer) response.jsonPath().get("id"), "Id is not match");
        Assertions.assertEquals(userName, response.jsonPath().get("username"), "username is not match");
        Assertions.assertEquals("özcan", response.jsonPath().get("firstName"), "firstname is not match");
        Assertions.assertEquals("arpaci", response.jsonPath().get("lastName"), "lastname is not match");
        Assertions.assertEquals("ozcan@gmail.com", response.jsonPath().get("email"), "email is not match");
        Assertions.assertEquals("1234567", response.jsonPath().get("password"), "password is not match");
        Assertions.assertEquals("5451111111", response.jsonPath().get("phone"), "phone is not match");
        Assertions.assertEquals(0, (Integer) response.jsonPath().get("userStatus"), "userStatus is not match");
    }

    @Test
    @Order(3)
    public void put() {

        request.setFirstName("kemal");
        Response response = HttpClient.put(userPath+userName, request);

        Verify.statusCode(response, 200);
        Assertions.assertEquals("1", response.jsonPath().get("message"), "Message codes are not match");
    }

    @Test
    @Order(4)
    public void delete() {
        Response response = HttpClient.delete(userPath + userName);
        Assertions.assertEquals(200, response.statusCode(), "Status codes are not match");
        Assertions.assertEquals("ozcana", response.jsonPath().get("message"), "Message codes are not match");
    }
}
