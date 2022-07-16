package uk.co.coral.sports.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {
    // set up the environment
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI ="https://buildyourbet.prod.coral.co.uk/api/v1/events";
    }
}
