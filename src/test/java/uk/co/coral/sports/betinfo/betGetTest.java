package uk.co.coral.sports.betinfo;

import io.restassured.response.Response;
import org.junit.Test;
import uk.co.coral.sports.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class betGetTest extends TestBase {
    @Test
    public void getAllEvents() {
        Response response = given()
                .when()
                .get();
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
