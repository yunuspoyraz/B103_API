package test_data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderTestData {

    public Map<String, Object> expectedDataMethod(Integer userId, String title, Boolean completed){

        Map<String, Object> expectedData  =new HashMap<>();
        if (userId!=null){ // Eklemek istemediğim degerleri null atıyorum.
            expectedData.put("userId", userId);
        }

        if (title!=null){ // Eklemek istemediğim degerleri null atıyorum.
            expectedData.put("title", title);
        }

        if (completed!=null){ // Eklemek istemediğim degerleri null atıyorum.
            expectedData.put("completed", completed);
        }

        return expectedData;
    }

public static String expectedDataInString(Integer userId, String title, Boolean completed){

    return "{ \"userId\": "+userId+", \"title\": \""+title+"\", \"completed\": "+completed+" }";


}

        }

/*
   {
   "userId": 10,
    "id": 198,
	"title": "quis eius est sint explicabo",
	"completed": true
	 }

 */


/*
       Map<String, Object> expected_data = new HashMap<>();
        expected_data.put("userId", 21.0);
        expected_data.put("title", "Wash the dishes");
        expected_data.put("completed", false);
 */