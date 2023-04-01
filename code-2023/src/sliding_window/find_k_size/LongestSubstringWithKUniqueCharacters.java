package sliding_window.find_k_size;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

    public static void main(String[] args) {

        String string = "aabacbebebe";
        int k = 3;
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, max = Integer.MIN_VALUE;

        while (j < string.length()) {
            char c = string.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() < k)
                j++;
            else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                // This block is executable when (map.size() > k).
                while (map.size() > k) {
                    if (map.containsKey(string.charAt(i)))
                        map.put(string.charAt(i), map.get(string.charAt(i)) - 1);
                    if (map.get(string.charAt(i)) == 0)
                        map.remove(string.charAt(i));
                    i++;
                }
                j++;
            }
        }
        System.out.println("Longest Sub string with K unique characters : " + max);
    }
}
