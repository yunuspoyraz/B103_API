package get_requests;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class RequestResponse {

/*
    1)Postman manuel API testi için kullanilir.
    2)API otomasyonu için Rest-Assured Library kullanacagiz.
    3)Otomasyon kodlarının yazımı için şu adımları izliyoruz:
        a) Gereksinimleri anlama
        b) Test case i yazma:
            -Test case i yazmak için "Gherkin Language" kullaniyoruz.
                x) Given: Ön koşullar  --> Endpoint, body
                y) When : İşlemler --> Get,Put,Delete...
                z) Then : Dönütler --> Assert
                t) And --> Çoklu işlemlerin art arda yazilacağı yerlerde kullanilir.
        c) Test kodunu yazarken şu adımları izleriz:
                i)    Set the URL
                ii)   Set the expected data
                iii)  Send the request and get the response
                iv)   Do assertion
 */

    public static void main(String[] args) {

        String url="https://restful-booker.herokuapp.com/booking/55";
        //Get request nasıl yapılır?

        Response response = given().when().get(url); // get() response data type (class) return ettiği için response class ında response adında bir variable (container) olusturduk.
        response.prettyPrint(); // prettyPrint() methodu response datayı yazdırır.

        //Status Code nasıl yazdırılır?
        System.out.println("Statues Code : " + response.statusCode());

        //Content Type nasıl yazdırılır?
        System.out.println("Content Type : " + response.contentType());

        //Status Line nasıl yazdırılır?
        System.out.println("Status Line : " + response.statusLine());

        //Header nasıl yazdırılır?
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));

        //Headers nasil yazdirilir?
        System.out.println(response.headers());
        System.out.println(response.getHeaders());

        //Time nasıl yazdırılır?
        System.out.println("Time: " + response.getTime());

    }




}
