package prepare;

import java.util.HashMap;
import java.util.Map;

public class SubArrayOfGivenSum {

    public static void main(String[] args) {
        int[] arr = {10, 15, -5, 15, -10, 5};
        int sum = 20;

        solution(arr, sum);
    }

    private static void solution(int[] arr, int sum) {
        int currentSum = 0, start = 0, end = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == sum) {
                end = i;
                break;
            }
            if (map.containsKey(currentSum - sum)) {
                start = map.get(currentSum - sum) + 1;
                end = i;
                break;
            }
            map.put(currentSum, i);
        }
        if (end == -1)
            System.out.println("Sub array not found for the given sum");
        else
            System.out.println("Sub array found, starts at " + start + " and ends at " + end);
    }
}
