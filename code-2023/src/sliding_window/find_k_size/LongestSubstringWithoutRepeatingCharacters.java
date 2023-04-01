package sliding_window.find_k_size;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        String string = "pwswkewin";
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, max = Integer.MIN_VALUE;

        while (j < string.length()) {
            char c = string.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() == j - i + 1) {
                max = Math.max(max, j - i + 1);
            } else {
                while (map.size() < j - i + 1) {
                    if (map.containsKey(string.charAt(i)))
                        map.put(string.charAt(i), map.get(string.charAt(i)) - 1);
                    if (map.get(string.charAt(i)) == 0)
                        map.remove(string.charAt(i));
                    i++;
                }
            }
            j++;
        }
        System.out.println("Longest Sub string with all unique characters : " + max);
//       TODO: usingSetApproach(string);
    }

    private static void usingSetApproach(String string) {
        int i = 0, j = 0, max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (char c : string.toCharArray()) {
            set.add(c);
        }
        System.out.println(set);

//        while (j <string.length()){
//
//        }
    }
}
