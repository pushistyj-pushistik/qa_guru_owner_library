package guru.qa.owner;

import guru.qa.owner.config.APIConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.is;

public class APITests {
    @Test
    void testLogin () {
        APIConfig config = ConfigFactory.create(APIConfig.class, System.getProperties());

        String body = "{ \"email\": \"eve.holt@reqres.in\", " +
                "\"password\": \"cityslicka\" }";

        given()
                .body(body)
                .contentType(JSON)
                .when()
                .post(config.baseUrl())
                .then()
                .log().body()
                .statusCode(200)
                .body("token", is(config.token()));
    }

}

