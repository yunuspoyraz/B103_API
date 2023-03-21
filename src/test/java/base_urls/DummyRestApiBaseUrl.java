package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApiBaseUrl {
    protected  RequestSpecification spec;

    @Before //Her test method undan önce calısır.
    public void setup(){

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://dummy.restapiexample.com/api/v1").build();
        //setAccept("application/json")==> request yaptıgımızda, karsı tarafın kabul edeceği data type'ı gönderiyoruz. DATA TYPE: JSON
        //Accept type is “application/json”
    }

}

// spec ilk create ettiğimizde null dır.
// setup() methos-du calısarak spec içine assigment (atama) yapar. (istediğimiz BASE URL yi atarız veya gerekli baska setupları yapabiliriz.)
// @Before anatosyonu ile her test den önce setup() methodunu çalıştırmış oluruz.
