package test_data;

import java.util.HashMap;
import java.util.Map;

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






}

/*
       Map<String, Object> expected_data = new HashMap<>();
        expected_data.put("userId", 21.0);
        expected_data.put("title", "Wash the dishes");
        expected_data.put("completed", false);
 */