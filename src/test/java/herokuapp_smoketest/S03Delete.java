package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest.S01_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static util.AuthenticationHerOkuApp.generateToken;

public class S03Delete extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/429
    When
        Send delete request
    Then
        Status Code should be 201
    And
        Body should be "Created"
     */

@Test
    public void delete01(){

    //Set the URL
    spec.pathParams("first", "booking", "second", 507);

    //Set the expected data
    String expectedData = "Created";

    //Set the request and get the response
    Response response=given().
                        spec(spec).
    //                    header("Cookie", "token="+generateToken()). baseUrl e token üreten method u ekledik.
                        when().
                        delete("/{first}/{second}");

    //Do assertion
    assertEquals(201, response.statusCode());
    assertEquals(expectedData, response.asString());


}

}
