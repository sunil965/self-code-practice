package prepare;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * String input =  "3a3b4c2d";
 * Expected output - "aaabbbccccdd"
 */
public class ChangeAlphaNumericToString {

    public static void main(String[] args) {
        String input = "3a3b4c2de5f";

        print(input);

//        usingMap(input);
    }

    private static void usingMap(String input) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int count = Integer.parseInt(String.valueOf(chars[i - 1]));
            map.put(chars[i], count);
            i++;
        }
        System.out.println(map);
        Set<Character> keySet = map.keySet();
        StringBuilder builder = new StringBuilder();
        for (char c : keySet) {
            int count = map.get(c);
            while (count > 0) {
                builder.append(c);
                count--;
            }
        }
        System.out.println(builder);
    }

    private static void print(String input) {
        StringBuilder builder = new StringBuilder();
        int charCount;

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (!Character.isDigit(c)) {
                System.out.println("Character:::" + c);
                continue;
            }

            if (Character.isDigit(c)) {
                charCount = Integer.parseInt(String.valueOf(c));
                System.out.println("number::::" + charCount);
                builder.append(String.valueOf(input.charAt(i + 1)).repeat(Math.max(0, charCount)));
            }
        }
        System.out.println("String = " + builder);
    }
}
