package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Anagram {

    public static void main(String[] args) {
        // [^a-zA-Z] - Regex to remove space & special characters.
        String one = "hello there! 21".replaceAll("[^a-zA-Z]", "").toLowerCase();
        String two = "THERE HELOO!".replaceAll("[^a-zA-Z]", "").toLowerCase();

        arraySortApproach(one, two);
        System.out.println("-------*-------------------*--------");
        approachWith3ForLoopIteration(one, two);
        System.out.println("-------*-------------------*--------");
        approachWith2ForLoopIteration(one, two);
    }

    private static void arraySortApproach(String one, String two) {
        char[] s1 = one.toCharArray();
        char[] s2 = two.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);
        if (new String(s1).equals(new String(s2)))
            System.out.println("Given Strings are an Anagram Strings.");
        else
            System.out.println("Given Strings are not Anagram Strings.");
    }

    private static void approachWith2ForLoopIteration(String stringOne, String stringTwo) {
        if (stringOne.length() != stringTwo.length()) {
            System.out.println("Given Strings are Not an Anagram Strings as there lengths are not same.");
            return;
        }

        Map<Character, Integer> map = convertToMap(stringOne);
        System.out.println("String Map " + map);
        for (char c : stringTwo.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) - 1);
            if (map.get(c) != null && map.get(c) == 0)
                map.remove(c);
        }
        System.out.println("String Map " + map);

        if (map.keySet().size() == 0)
            System.out.println("Given Strings are an Anagram Strings.");
        else
            System.out.println("Given Strings are not Anagram Strings.");
    }

    private static void approachWith3ForLoopIteration(String one, String two) {
        if (one.length() != two.length()) {
            System.out.println("Given Strings are Not an Anagram Strings as there lengths are not same.");
            return;
        }

        Map<Character, Integer> mapOne = convertToMap(one);
        Map<Character, Integer> mapTwo = convertToMap(two);
        System.out.println("First  String Map " + mapOne);
        System.out.println("Second String Map " + mapTwo);

        if (checkForMapContent(mapOne, mapTwo))
            System.out.println("Given Strings are an Anagram Strings.");
        else
            System.out.println("Given Strings are Not Anagram Strings.");
    }

    private static boolean checkForMapContent(Map<Character, Integer> mapOne, Map<Character, Integer> mapTwo) {
        for (char c : mapOne.keySet()) {
            if (!Objects.equals(mapOne.get(c), mapTwo.get(c)))
                return false;
        }
        return true;
    }

    private static Map<Character, Integer> convertToMap(String stringInput) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : stringInput.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
