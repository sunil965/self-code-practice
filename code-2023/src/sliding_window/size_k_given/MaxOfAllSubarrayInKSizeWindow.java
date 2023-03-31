package sliding_window.size_k_given;

import java.util.*;

/**
 * Program to find the MAX number in every Sub arrays of the given array where the size of sub arrays is K.
 * Input [1, 3, -1, -3, -2, 5, 3, 6, 7]
 * Result [3, 3, -1, 5, 5, 6, 7]
 */
public class MaxOfAllSubarrayInKSizeWindow {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Input " + Arrays.toString(arr));

        Queue<Integer> queue = new ArrayDeque<>();

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (j < arr.length) {

            while (queue.size() > 0 && queue.peek() < arr[j]) {
                queue.poll();
            }
            queue.add(arr[j]);

            if ((j - i + 1) < k)
                j++;
            else if ((j - i + 1) == k) {
                result.add(queue.peek());

                if (!queue.isEmpty() && queue.peek() == arr[i]) {
                    queue.poll();
                }
                i++;
                j++;
            }
        }
        System.out.println("Result " + result);
    }
}

/*
 *        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
 *
 *         int i=0,j=0;
 *         List<Integer> result = new ArrayList<>();
 *
 *         while (j< arr.length){ *
 *             pq.add(arr[j]);
 *             if ((j-i+1)<k)
 *                 j++;
 *             else if ((j - i + 1) == k) {
 *                 if (pq.isEmpty())
 *                     result.add(0);
 *                 else if (arr[i] == pq.peek()) {
 *                     result.add(pq.poll());
 *                 }else
 *                     result.add(pq.peek());
 *                 i++;
 *                 j++;
 *             }
 *         }
 *         System.out.println("Result "+result);
 */