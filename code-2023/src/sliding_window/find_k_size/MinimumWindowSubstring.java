package sliding_window.find_k_size;

import java.util.HashMap;
import java.util.Map;

/**
 * Program to find the Minimum Window Substring of a given string 'S' which has all the character of another string 'T'.
 * The Substring must have all the character of T at latest in same count, it can be more but not less.
 *
 * Input : String s = "this is a test string";
 *         String t = "tist";
 *
 * Output: Min Window Substring : 6 and substring is : 't stri'.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "this is a test string";
        String t = "tist";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0, start = 0, minStrLength = Integer.MAX_VALUE;
        int count = map.size();

        while (j < s.length()) {
            count = reduceMapWithCharAtJ(s, map, j, count);
            if (count == 0) {
                while (count == 0) {
                    if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        if (map.get(s.charAt(i)) > 0)
                            count++;
                    }
                    if (minStrLength > j - i + 1) {
                        minStrLength = Math.min(minStrLength, j - i + 1);
                        start = i;
                    }
                    i++;
                }
            }
            j++;
        }
        System.out.format("Min Window Substring : %s and substring is : '%s'.", minStrLength, s.substring(start, start+minStrLength));
    }

    private static int reduceMapWithCharAtJ(String s, Map<Character, Integer> map, int j, int count) {
        if (map.containsKey(s.charAt(j))) {
            map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
            if (map.get(s.charAt(j)) == 0)
                count--;
        }
        return count;
    }
}
