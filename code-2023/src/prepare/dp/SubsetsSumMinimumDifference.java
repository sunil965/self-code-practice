package prepare.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program to find the Minimum difference of all Subset in the given Array.
 * Ex: I/P = int[] arr = {1, 2, 7}
 <p>
  Solution :
  1) Calculate Range of given array = Sum of all elements = 10 (In this case)
  2) Now create matrix as "t = new boolean[n + 1][range + 1]"
  3) Check if subset exist within the given array via Subset Sum Problem where SUM = Sum of all element in the given array.
  4) After that get store the Range Integer value from the last ROW of the matrix in a LIST wherever value is TRUE.
  5) Now find the minimum of all subsets formed via "[Range - (2 * Each Item In List)]".
      => S2 - S1 = Should be minimum, S1 & S2 are the sum of subsets.
      => S2 = (Range -S1)
      => therefore S2 - S1 => (Range -S1) - S1 => [Range -(2 * S1)]
      => hence [Range - (2 * S1)] Should be minimum.
 </p>
 */

public class SubsetsSumMinimumDifference {

    public static void main(String[] args) {

        int[] arr = {1, 2, 7};

        int n = arr.length;

        int range = Arrays.stream(arr).sum();

        boolean[][] t = new boolean[n + 1][range + 1];

        subSetSumProblem(arr, n, range, t);

//        printArray(range, n, t);

        // Get the eligible candidates form the range which can be produced bia the elements og given array in a list.
        List<Integer> list = new ArrayList<>();
        int k = 0;
        while (k <= range) {
            if (t[n - 1][k])
                list.add(k);
            k++;
        }

        // Find the minimum difference of all subsets formed via given array.
        int min = Integer.MAX_VALUE;
        for (int r : list) {
            min = Math.min(min, Math.abs(range - 2 * r));
        }

        System.out.println("Minimum difference between subset of given array is : " + min);
    }

    private static void subSetSumProblem(int[] arr, int n, int range, boolean[][] t) {
        // Initialization of Matrix.
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < range + 1; j++) {
                if (j == 0)
                    t[i][j] = true;
            }
        }

        // Choice logic to fill the Matrix.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < range + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                else if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
    }

    public static void printArray(int k, int n, Object[][] t) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
