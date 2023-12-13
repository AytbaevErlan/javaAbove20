package allLec.lecture36m.task2;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class StringPairs {
    public static void main(String[] args) {
        String[] array1 = {"code", "bug"};
        String[] array2 = {"man", "moon", "main"};
        String[] array3 = {"man", "moon", "good", "night"};

        System.out.println(convertToJson(pairs(array1)));
        System.out.println(convertToJson(pairs(array2)));
        System.out.println(convertToJson(pairs(array3)));
    }

    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> result = new HashMap<>();

        for (String str : strings) {
            if (!str.isEmpty()) {
                char firstChar = str.charAt(0);
                char lastChar = str.charAt(str.length() - 1);
                result.put(String.valueOf(firstChar), String.valueOf(lastChar));
            }
        }

        return result;
    }

    public static String convertToJson(Map<String, String> map) {
        Gson gson = new Gson();
        return gson.toJson(map);
    }
}
