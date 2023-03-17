package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/23
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
    {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "midnight snack"
}

   */

    @Test
    public void get06(){

        //1- Set the url
        spec.pathParams("first","booking", "second", 23);

        //2- Set the expected data

        //3- Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4- Do Assertion
        //1.yol:
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("Josh"),
                        "lastname", equalTo("Allen"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("midnight snack"));

        //2.yol:
        JsonPath jsonPath = response.jsonPath();

        assertEquals("Josh", jsonPath.getString("firstname"));
        assertEquals("Allen", jsonPath.getString("lastname"));
        assertEquals(111, jsonPath.getInt("totalprice"));
        assertTrue(jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
        assertEquals("super bowls", jsonPath.getString("additionalneeds"));

        //3.yol: testNG (test New Generation) Soft Assert

            //1. SoftAssert objesi olustur.
            SoftAssert softAssert =new SoftAssert();

            //2. Assertion
            softAssert.assertEquals(jsonPath.getString("firstname"), "Josh");
            softAssert.assertEquals(jsonPath.getString("lastname"), "Allen");
            softAssert.assertEquals(jsonPath.getInt("totalprice"), 111);
            softAssert.assertTrue(jsonPath.getBoolean("depositpaid"),"depositepaid uyusmadı");
            softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"), "2018-01-01");
            softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"), "2019-01-01");
            softAssert.assertEquals(jsonPath.getString("additionalneeds"), "midnight snack");

            //3. softAssert.assrtAll() diyerek dogrulamayı kontrol et. Aksi taktirde test hep "PASS" olur.
            softAssert.assertAll();

    }



}
