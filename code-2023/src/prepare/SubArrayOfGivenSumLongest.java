package prepare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayOfGivenSumLongest {

    public static void main(String[] args) {
        int[] arr = {10, 15, -5, 15, -10, 5};
        int sum = 20;

        solution(arr, sum);

        /*
        Que:
            If we are given a binary array like {0, 1, 1, 0, 0, 0, 1, 0, 1}
            and we are asked to find Longest ub array which has same number of '0' & '1'.
        Solution:
            First of all convert all '0' to '-1' in the given array after then find the
            Longest sub array and assume Sum given as '0', we will get the output.
        */
        System.out.println();
        int[] arr2 = {0, 1, 1, 0, 0, 0, 1, 0, 1};
        System.out.println("Given Binary array is :" + Arrays.toString(arr2));
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == 0)
                arr2[i] = -1;
        }
        System.out.println("Converted Binary array is :" + Arrays.toString(arr2));
        solution(arr2, 0);
    }

    private static void solution(int[] arr, int sum) {
        int currentSum = 0, start = 0, end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int largest = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum == sum) {
                start = 0;
                end = i;
                largest = Math.max(largest, end - start + 1);
                System.out.println("Sub array found, starts at " + start + " and ends at " + end + " with length " + (end - start + 1));
            }
            if (map.containsKey(currentSum - sum)) {
                start = map.get(currentSum - sum) + 1;
                end = i;
                largest = Math.max(largest, end - start + 1);
                System.out.println("Sub array found, starts at " + start + " and ends at " + end + " with length " + (end - start + 1));
            }
            map.put(currentSum, i);
        }
        if (end == -1)
            System.out.println("Sub array not found for the given sum");
        else
            System.out.println("The Longest Sub array found of length " + largest);
    }

}
