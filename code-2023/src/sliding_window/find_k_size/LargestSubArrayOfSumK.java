package sliding_window.find_k_size;

import java.util.HashMap;

/**
 * This program can work with an array of either positive number or negative number combination of positive & negative number
 * to find the Largest sub array where sum of elements is any given number.
 */
public class LargestSubArrayOfSumK {

	public static void main(String[] args) {
//		int[] arr = {4, 1, 1, -2, 1, 5};
//		int sum = 5;

//		int[] arr = {4, 1, 1, 1, 2, 3, 5};
//		int sum = 5;
		int[] arr = {-5, 8, -14, 2, 4, 12};
		int sum = -5;
		int n = arr.length;
		subArraySum(arr, n, sum);
	}

	private static void subArraySum(int[] arr, int n, int givenSum) {
		int currentSum = 0, start = 0, end;
		int maxLength = Integer.MIN_VALUE;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			currentSum += arr[i];

			if (currentSum == givenSum) {
				end = i;
				System.out.println("Sum found between indexes " + start + " to " + end);
				maxLength = Math.max(end - start + 1, maxLength);
			}
			if (map.containsKey(currentSum - givenSum)) {
				start = map.get(currentSum - givenSum) + 1;
				end = i;
				System.out.println("Sum found between indexes " + start + " to " + end);
				maxLength = Math.max(end - start + 1, maxLength);
			}
			map.put(currentSum, i);
		}
		System.out.println("Max size Sub Array " + maxLength);
	}

}
