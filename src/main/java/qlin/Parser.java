package qlin;

import java.util.HashMap;

/**
 * The class that contains the method parse or breakString.
 */
public class Parser {

    /**
     * Return an array of strings that contain trimmed strings from the input, s.
     * Each string is separated from other string by "/".
     * Example: "a /b /  c" returns {"a", "b", "c"}
     * @param s A string
     * @return An array of Strings
     */
    public static String[] breakString(String s) {
        s = "/" + s; // special adjustment
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/') {
                hashmap.put(count, i);
                count++;
            }
        }
        String[] result = new String[count];
        for (int i = 0; i < count - 1; i++) {
            int indexS = hashmap.get(i);
            int indexE = hashmap.get(i + 1);
            String sub = s.substring(indexS + 1, indexE).trim();
            result[i] = sub;
        }
        int indexS = hashmap.get(count - 1);
        String sub = s.substring(indexS + 1).trim();
        result[count - 1] = sub;
        return result;
    }
}
