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
            char charAtJ = string.charAt(j);
            map.put(charAtJ, map.getOrDefault(charAtJ, 0) + 1);

            if (map.size() < k)
                j++;
            else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                // This block is executable when (map.size() > k).
                while (map.size() > k) {
                    char charAtI = string.charAt(i);
                    if (map.containsKey(charAtI))
                        map.put(charAtI, map.get(charAtI) - 1);
                    if (map.get(charAtI) == 0)
                        map.remove(charAtI);
                    i++;
                }
                j++;
            }
        }
        System.out.println("Longest Sub string with K unique characters : " + max);
    }
}
