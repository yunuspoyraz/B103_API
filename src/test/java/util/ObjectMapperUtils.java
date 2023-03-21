package util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {


    //<T> => Herhangi bir data type return edecek demektir.

    /*

    Note: <T> T ==> Herhangi bir data tipi demektir. / methodlarda kullanılır.
          ObjectMapper().readValue(json, cls) methodu birinci parametrede aldığı String formatındaki Json datayı ikinci parametrede belitilen Java objesine çevirir.
     */

    public static <T> T convertJsonToJava(String json, Class<T> cls){ // Bu method String degeri(data) herhangi bir data type'a cevirir. //Generic Method
                                                                      // Json ==> Class<T> cls

        //generic methodlar devreye giriyor test classında exception istemiyoruz bu yuzden baska bir class da exception ı trycatch ile handle edecegiz
        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
