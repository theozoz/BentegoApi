package base.helpers;

import io.restassured.response.Response;

import static base.constant.BaseConstants.SCHEMA_DIR_PATH;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Verify {
    public static void schemaVerify(Response response, String schemaName) {
        response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(SCHEMA_DIR_PATH + schemaName));
    }

    public static void statusCode(Response response, int statusCode) {
        response
                .then()
                .assertThat().statusCode(statusCode);
    }

}
