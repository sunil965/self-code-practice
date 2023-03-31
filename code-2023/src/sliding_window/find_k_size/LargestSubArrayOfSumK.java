package sliding_window.find_k_size;

import java.util.HashMap;

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

	private static void subArraySum(int[] arr, int n, int sum) {
		int cSum = 0;
		int start = 0;
		int end;
		int maxLength = Integer.MIN_VALUE;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			cSum += arr[i];
			if (cSum == sum) {
				end = i;
				System.out.println("Sum found between indexes " + start + " to " + end);
				maxLength = Math.max(end - start + 1, maxLength);
			}
			if (map.containsKey(cSum - sum)) {
				start = map.get(cSum - sum) + 1;
				end = i;
				System.out.println("Sum found between indexes " + start + " to " + end);
				maxLength = Math.max(end - start + 1, maxLength);
			}
			map.put(cSum, i);
		}
		System.out.println("Max size Sub Array " + maxLength);
	}

}
