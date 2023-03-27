package delete_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.DummyRestApiDeleteBodyPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {

    /*
    URL: https://dummy.restapiexample.com/api/v1/delete/2
    HTTP Request Method: DELETE Request
    Test Case: Type by using Gherkin Language
    Assert:     i) Status code is 200
            ii) "status" is "success"
            iii) "data" is "2"
            iv) "message" is "Successfully! Record has been deleted"
   */

      /*
      ***************************Test CASE*************************************
    Given
        URL: https://dummy.restapiexample.com/api/v1/delete/2
    When
        HTTP Request Method: DELETE Request

    Then
         i) Status code is 200
    And
         ii) "status" is "success"
    And
         iii) "data" is "2"
    And
         iv) "message" is "Successfully! Record has been deleted"
   */

    @Test
    public void delete02(){

        //Set the URL
        spec.pathParams("first","delete", "second",2);

        //Set the expectedData
        DummyRestApiDeleteBodyPojo expectedData = new DummyRestApiDeleteBodyPojo("success", "2","Successfully! Record has been deleted");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response= given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        DummyRestApiDeleteBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),DummyRestApiDeleteBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getData(),actualData.getData());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
    }


}
