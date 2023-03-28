package sliding_window.size_k_given;

import java.util.*;

public class AnagramOccurrenceCount {
    public static void main(String[] args) {
        String mainStr = "aabaabaa";
        String second = "aaba";

//        Map<String, Long> map = Arrays.stream(second.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        Map<Character, Integer> map = new HashMap<>();
        for (char c : second.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int k = second.length(); // window size
        int i = 0, j = 0;
        int result = 0;
        int count = map.size();

        while (j < mainStr.length()) {

            count = getCountAfterJIncrementsToIncludeNewValue(mainStr, map, j, count);

            if ((j - i + 1) < k)
                j++;

            else if ((j - i + 1) == k) {
                if (count == 0)
                    result++;
                count = getCountBeforeIIncrementsToExcludeOldValue(mainStr, map, i, count);
                i++;
                j++;
            }
        }
        System.out.println(result);
    }

    private static int getCountBeforeIIncrementsToExcludeOldValue(String mainStr, Map<Character, Integer> map, int i, int count) {
        if (map.containsKey(mainStr.charAt(i))) {
            map.put(mainStr.charAt(i), map.get(mainStr.charAt(i)) + 1);
        }
        if (map.get(mainStr.charAt(i)) == 1)
            count++;
        return count;
    }

    private static int getCountAfterJIncrementsToIncludeNewValue(String mainStr, Map<Character, Integer> map, int j, int count) {
        if (map.containsKey(mainStr.charAt(j))) {
            map.put(mainStr.charAt(j), map.get(mainStr.charAt(j)) - 1);
        }
        if (map.get(mainStr.charAt(j)) == 0)
            count--;
        return count;
    }

}
