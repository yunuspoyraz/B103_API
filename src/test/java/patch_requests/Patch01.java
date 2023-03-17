package patch_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {
/*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */

    @Test
    public void patch01(){

        //Set the URL
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod(null,"Wash the dishes", null);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).body(expectedData).patch("/{first}/{second}");
        response.prettyPrint();

        //Data Assertion
        Map<String, Object> actualData = new HashMap<>();
        actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.get("title"), actualData.get("title"));

    }


}
