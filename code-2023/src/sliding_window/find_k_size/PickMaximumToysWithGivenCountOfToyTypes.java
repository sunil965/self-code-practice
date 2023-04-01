package sliding_window.find_k_size;

import java.util.HashMap;
import java.util.Map;

/**
 * Que: Jack & his mother went to a shop to purchase Toys. Mother said you can purchase any number of a Toy from the
 * Rack(having different Toys) but the condition is that the type of Toy can't be more than two and selection should be continuous.
 * Eg:- Rack = [car, bat, boll, ball, helicopter, car, car, helicopter, bat]
 * <p>
 * How can Jack pick maximum number of toys ?
 * In the given example if Jack choose [helicopter, car, car, helicopter] then only he can have a maximum of 4 toys.
 */
public class PickMaximumToysWithGivenCountOfToyTypes {

    public static void main(String[] args) {
        // Let's assume the character of string represent toys.
        String toys = "abaccab";
        // Condition to pick maximum type of toys.
        int maxToyType = 2;

        Map<Character, Integer> toyMap = new HashMap<>();

        int i = 0, j = 0, maxToy = Integer.MIN_VALUE;

        while (j < toys.length()) {
            char keyWithJ = toys.charAt(j);
            toyMap.put(keyWithJ, toyMap.getOrDefault(keyWithJ, 0) + 1);

            if (toyMap.size() < maxToyType)
                j++;
            else if (toyMap.size() == maxToyType) {
                maxToy = Math.max(maxToy, j - i + 1);
                j++;
            } else {
                while (toyMap.size() > maxToyType) {
                    char keyWithI = toys.charAt(i);
                    if (toyMap.containsKey(keyWithI))
                        toyMap.put(keyWithI, toyMap.get(keyWithI) - 1);
                    if (toyMap.get(keyWithI) == 0)
                        toyMap.remove(keyWithI);
                    i++;
                }
                j++;
            }
        }
        System.out.println("Maximum Toys count : " + maxToy);
    }
}
