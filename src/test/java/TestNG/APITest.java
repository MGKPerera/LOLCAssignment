package TestNG;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static sun.net.InetAddressCachePolicy.get;

public class APITest {


    @Test(priority = 1)
    public void testGetRequest() {

        RestAssured.baseURI = "https://api.restful-api.dev";
        given().
                queryParam("objects","7")
                .body("")
                .when().
                        get()
                .then().
                        assertThat().statusCode(200);

    }

    //create
    @Test(priority = 2)
    public void testPostRequest() {

        RestAssured.baseURI = "https://api.restful-api.dev";

        String userData ="{\"createdAt\": \"2022-11-21T20:06:23.986Z\"}";
        given().body(userData)
                .when().
                post()
                .then().log().all()
                .assertThat()
                .statusCode(200);

    }

    //update
    @Test(priority = 3)
    public void testPutRequest() {

        RestAssured.baseURI = "https://api.restful-api.dev";

        String userData ="{\"updatedAt\": \"2022-12-25T21:08:41.986Z\"}";
        given().body(userData)
                .when().
                put()
                .then().log().all()
                .assertThat()
                .statusCode(200);

    }

    //delete
    @Test(priority = 4)
    public void testDeleteRequest() {

        RestAssured.baseURI = "https://api.restful-api.dev";
        String endpoint ="/objects/6";

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();


//         Verify the status code (204 is typically returned for a successful DELETE operation with no content)
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
