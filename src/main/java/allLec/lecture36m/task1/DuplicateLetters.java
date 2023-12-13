package allLec.lecture36m.task1;

import java.util.HashMap;
import java.util.Map;

public class DuplicateLetters {
    public static void main(String[] args) {
        String[] array1 = {"a", "b", "a", "c", "b"};
        String[] array2 = {"c", "b", "a"};
        String[] array3 = {"c", "c", "c", "c"};
        String[] array4 = {"q", "w", "e", "e", "w", "t"};

        System.out.println(duplicateLetters(array1));
        System.out.println(duplicateLetters(array2));
        System.out.println(duplicateLetters(array3));
        System.out.println(duplicateLetters(array4));
    }

    public static Map<String, Boolean> duplicateLetters(String[] strings) {
        Map<String, Boolean> result = new HashMap<>();
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String str : strings) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        for (String key : frequencyMap.keySet()) {
            result.put(key, frequencyMap.get(key) >= 2);
        }

        return result;
    }
}