package sliding_window.size_k_given;

import java.util.*;

/**
 * Find First Negative Number In Every Sub Array Of Window Size K.
 * Given:
 * int[] arr = {12,-1,-7,8,-15, 30, 16, 28};
 * int k=3;
 * Output:
 * -1,-1,-7,-15,-15
 */
public class FirstNegativeNumberInEveryWindowOfSizeK {

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println("Given array: " + Arrays.toString(arr));

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (j < arr.length) {
            if (arr[j] < 0)
                queue.add(arr[j]);
            if ((j - i + 1) < k)
                j++;
            else if ((j - i + 1) == k) {
                if (queue.isEmpty())
                    list.add(0);
                else if (arr[i] == queue.peek()) {
                    // Add head of queue in list and remove from queue. Case: it is the 1st -ve element in the given window.
                    list.add(queue.poll());
                } else {
                    // Only add head of the queue in list. Case: it is not the 1st -ve element in the given window, so it
                    // can be the 1st -ve for next upcoming subarray window of size k.
                    list.add(queue.peek());
                }
                i++;
                j++;
            }
        }
        System.out.println("Output List: " + list);
    }
}
