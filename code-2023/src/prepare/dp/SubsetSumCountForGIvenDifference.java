package prepare.dp;

import java.util.Arrays;

/**
 * Problem: To count the number of subsets where the Difference of the SUM of their elements is equal to given number.
 * Input: int[] arr = {1,1,2,3};  int diff = 1;
 <p>
     Approach: Change the given problem to "Count of Number of Subset Problem for a given sum".
 </p>
 <p>
     Solution: It needs mathematical logic to solve as-
      -> Two subsets of given array could be [{1,1,2},{3}], [{1,3},{1,2}] and so on.
      -> Assume the S1 and S2 are sum of two subsets then as per the problem statement
      S1 - S2 = 1 OR S2 - S1 = 1 ---- (equation 1)
      -> Also, we know that if there are 2 subsets, and when we add the SUM of each subset then it will be equal
      to sum of given array elements(Represented as R) , that is
      S1 + S2 = R ---- (equation 2)
      -> Adding equation 1 & equation 2
      S1 - S2 = 1
      +
      S1 + S2 = R
      ------------
      2S1 = 1 + R   --> S1 = (1+R)/2, For given array R is 7 so S1 = (1+7)/2 = 4.
      ------------
      Now the problem is reduced to "Count of Number of Subset Problem for a given sum" where Sum = (1+R)/2.
 </p>
 */

public class SubsetSumCountForGIvenDifference {

    public static void main(String[] args) {

        // Given
        int[] arr = {1, 1, 2, 3};
        int diff = 1;

        int R = Arrays.stream(arr).sum();
        int s1 = (1 + R) / 2;

        int n = arr.length;
        int[][] t = new int[n + 1][s1 + 1];

        int numberOfSubsets = countNumberOfSubsets(arr, n, s1, t);
        System.out.format("Total number of subsets is - %s where the difference of their sum is %s.", numberOfSubsets, diff);
    }

    private static int countNumberOfSubsets(int[] arr, int n, int k, int[][] t) {
        // Initialization of matrix
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (j == 0)
                    t[i][j] = 1;
            }
        }

//        printArray(k, n, t);

        // Choice logic to fill the matrix
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                else if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        printArray(k, n, t);
        return t[n][k];
    }

    public static void printArray(int k, int n, int[][] t) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
