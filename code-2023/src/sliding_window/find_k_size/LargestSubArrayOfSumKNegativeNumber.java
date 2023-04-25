package sliding_window.find_k_size;

import java.util.HashMap;

/**
 * This Logic is applicable for array having Negative Numbers to find the Largest SubArray where sum of elements is any given number.
 */
public class LargestSubArrayOfSumKNegativeNumber {

    public static void main(String[] args) {
//        int[] arr = {4, 1, 1, -2, 1, 5};
//        int sum = 5;
        int[] arr = {-5, 8, -14, 2, 4, 12};
        int sum = -5;
        subArraySum(arr, sum);
    }

    private static void subArraySum(int[] arr, int K) {
        int currentSum = 0, largestSubArraySize = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == K)
                largestSubArraySize = i + 1;
            if (!map.containsKey(currentSum))
                map.put(currentSum, i);
            if (map.containsKey(currentSum - K))
                largestSubArraySize = Math.max(largestSubArraySize, i - map.get(currentSum - K) + 1);
        }
        System.out.println("Max window size for given K is : " + largestSubArraySize);
    }
}
