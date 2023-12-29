package dev.ericvega.rankforge.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class JSON {

    private static final Gson gson = new Gson();

    // Serialize the List into a string
    public static String serializeList(List<String> list) {
        return gson.toJson(list);
    }

    // Deserialize the string back into an ArrayList
    public static List<String> deserializeList(String serializedList) {
        // Check if the serializedList is null or empty
        if (serializedList == null || serializedList.isEmpty()) {
            return new ArrayList<>();
        }

        return gson.fromJson(serializedList, new TypeToken<List<String>>(){}.getType());
    }
}
