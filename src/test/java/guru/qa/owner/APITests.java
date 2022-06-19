package guru.qa.owner;

import guru.qa.owner.config.APIConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class APITests {
    static APIConfig config;

    @BeforeAll
    static void setUp() {
        config = ConfigFactory.create(APIConfig.class, System.getProperties());

        RestAssured.baseURI = config.baseUri();
    }

    @Test
    void testLogin() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", " +
                "\"password\": \"cityslicka\" }";

        given()
                .auth().oauth2(config.token())
                .body(body)
                .contentType(JSON)
                .when()
                .post("/login")
                .then()
                .log().body()
                .statusCode(200)
                .body("token", is(config.token()));
    }

}

