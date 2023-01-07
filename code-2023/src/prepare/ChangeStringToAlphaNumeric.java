package prepare;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given input = "aaabbbcccddaaaaaaabbbbbbb";
 * Expected output: 3a3b3c2d7a6b
 */
public class ChangeStringToAlphaNumeric {

    public static void main(String[] args) {
        String input = "aaabbbcccddaaaaaaabbbbbbb";

        // If we use map the output will be 'a10b10c3d2'
        usingMap(input);

        countCharacterNumber(input);
    }

    private static void countCharacterNumber(String input) {
        int count = 1;
        char[] chars = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i+1])
                count += 1;
            else {
                builder.append(count).append(chars[i]);
                count = 1;
            }
        }
        if (chars[chars.length-1] == chars[chars.length-2])
            builder.append(count).append(chars[chars.length-1]);
        System.out.println(builder);
    }

    private static void usingMap(String input) {
        char[] chars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        System.out.println(map);
        Set<Character> keySet = map.keySet();
        StringBuilder builder = new StringBuilder();
        for (char c : keySet) {
            builder.append(c).append(map.get(c));
        }
        System.out.println(builder);
    }
}
