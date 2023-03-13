package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04(){

        //1- Set thr URL
        //String url = "https://jsonplaceholder.typicode.com/todos";

        spec.pathParam("first", "todos"); //birinci (first) parametreyi "todos" olara tanımladık. ikinci, üçüncü... olarak sıra ile tanımlıyoruz.

        //2- Set the expected data

        //3- Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4- Do Assertion
        response.then().statusCode(200).
                contentType(ContentType.JSON). //Response format should be "application/json"
                body("id", hasSize(200), //There should be 200 todos
                "title", hasItem("quis eius est sint explicabo"), //"quis eius est sint explicabo" should be one of the todos title
                "userId", hasItems(2,7,9)); //2, 7, and 9 should be among the userIds
                                            // hasItems() methodu==> coklu datayı içerip içermediğinin kontrol ederiz.

    }


}
