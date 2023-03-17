package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/201
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									    "id": 198
									   }
     */

    @Test
    public void put01() {

        //1- Set the URL
        spec.pathParams("first","todos","second", 198);

        //2- Set the expected data (degistireceğimiz data yani yeni veriler)
        Map<String, Object> expected_data = new HashMap<>();  // data-type farklı oldugu icin object sectik. (data type leri aynı olsaydı string, int vb. secebilirdik.)
        expected_data.put("userId", 21.0);
        expected_data.put("title", "Wash the dishes");
        expected_data.put("completed", false);
        System.out.println("expectedData :" + expected_data);

        //3- Send the request and get the response
        Response response = given().spec(spec).when().contentType(ContentType.JSON).body(expected_data).put("/{first}/{second}"); //PUT REQUEST GÖNDERDİK.
                            //PUT yaparken "contentType(ContentType.JSON)" ekliyoruz cünkü veri(data) gönderdiğimiz için data type'ı (içerik) belirtmeliyiz.
                            //when() olmasada olur.
                            //given() basta, put() sonda olsun digerlerinin sırası degisebilir.
        response.prettyPrint();

        //4- Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expected_data.get("userId"), actualData.get("userId"));
        assertEquals(expected_data.get("title"), actualData.get("title"));
        assertEquals(expected_data.get("completed"), actualData.get("completed"));

    }

    @Test //Dinamik Yöntem
    public void put01b() {

        //1- Set the URL
        spec.pathParams("first","todos","second", 198);

        //2- Set the expected data (degistireceğimiz data yani yeni veriler)
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData(); // baska class daki objeye ulasmak için obje olusturduk.
        Map<String, Object> expected_data = obj.expectedDataMethod(21,"Wash the dishes",false);

        System.out.println("expectedData :" + expected_data);

        //3- Send the request and get the response
        Response response = given().spec(spec).when().contentType(ContentType.JSON).body(expected_data).put("/{first}/{second}"); //PUT REQUEST GÖNDERDİK.
        //PUT yaparken "contentType(ContentType.JSON)" ekliyoruz cünkü veri(data) gönderdiğimiz için data type'ı (içerik) belirtmeliyiz.
        //when() olmasada olur.
        //given() basta, put() sonda olsun digerlerinin sırası degisebilir.
        response.prettyPrint();

        //4- Do Assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expected_data.get("userId"), actualData.get("userId"));
        assertEquals(expected_data.get("title"), actualData.get("title"));
        assertEquals(expected_data.get("completed"), actualData.get("completed"));

    }
}

