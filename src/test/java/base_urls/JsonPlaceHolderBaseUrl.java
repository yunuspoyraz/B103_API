package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    protected  RequestSpecification spec;

    @Before //Her test method undan önce calısır.
    public void setup(){

        spec = new RequestSpecBuilder().setAccept("application/json").setContentType(ContentType.JSON).setBaseUri("https://jsonplaceholder.typicode.com").build();
        //setAccept("application/json")==> request yaptıgımızda, karsı tarafın kabul edeceği data type'ı gönderiyoruz. DATA TYPE: JSON
        //Accept type is “application/json”
        //setContentType(ContentType.JSON) ==> karsı tarafın göndereceği data type : JSON bu sebeple koyuyoruz. PUT, POST, PATCH yaparken mutlaka koymalıyız.
                                               //her defasında kodlara yazmamak için buraya ekledik.
    }

}

// spec ilk create ettiğimizde null dır.
// setup() methos-du calısarak spec içine assigment (atama) yapar. (istediğimiz BASE URL yi atarız veya gerekli baska setupları yapabiliriz.)
// @Before anatosyonu ile her test den önce setup() methodunu çalıştırmış oluruz.
