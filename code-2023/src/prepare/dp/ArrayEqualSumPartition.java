package prepare.dp;

import java.util.Arrays;

/**
 * Program to check if the given array can be split into two sub array where the sum of all elements
 * in each sub array are equal.
 * Solution: An array can be divided into two equal parts only if the sum of their elements is an EVEN number.
 * If the Sum of elements are even then check if any Subset of given array exists whose element's sum should be
 * half of the Sum of elements of Actual array.
 */
public class ArrayEqualSumPartition {

    public static void main(String[] args) {

        int[] arr = {1, 5, 11, 5, 1};

        int sum = Arrays.stream(arr).sum();

        if (sum % 2 != 0)
            // If Sum of elements is odd then they can't be divided in two equal parts without decimal value.
            System.out.println("Equal sum partition of given array is not possible.");
        else {
            boolean flag = checkASubsetElementSumIsHalfGivenArrayElementSum(arr, sum);
            System.out.format("Equal sum partition of given array is possible: %s.", flag);
        }

    }

    private static boolean checkASubsetElementSumIsHalfGivenArrayElementSum(int[] arr, int sum) {
        int n = arr.length;
        int k = sum / 2;
        boolean[][] t = new boolean[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0)
                    t[i][j] = true;
            }
        }

//        SubsetSumProblem.printArray(k, n, t);

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i][j - arr[i - 1]] || t[i - 1][j];
                else if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][k];
    }
}
