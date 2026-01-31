package qlin;

import java.util.HashMap;

public class Parser {

    /**
     * Return an array of strings that contain trimmed strings from the input, s.
     * Each string is separated from other string by "/".
     * Example: "a /b /  c" returns {"a", "b","c"}
     * Empty strings or strings that only consists of backspaces are ignored, "a/  //  /b" returns {"a", "b"}
     * Empty string returns {}
     * @param s A string
     * @return An array of Strings
     */
    public static String[] breakString(String s) {
        // special adjustment
        s = "/" + s;
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
        // remove any empty string
        int empty = 0;
        for (String t: result) {
            if (t.isEmpty()) empty += 1;
        }
        if (empty == 0) return result;
        int temp = count - empty;
        String[] a = new String[temp];
        temp = 0;
        for (String t: result) {
            if (!t.isEmpty()) {
                a[temp] = t;
                temp++;
            }
        }
        return a;
    }
}
