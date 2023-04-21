package prepare.dp;

import java.util.Arrays;

/**
 * Problem: Find different ways to place "+" OR "-" sign between the elements of a given array so that the Sum of all
 * elements with the symbol will be equal to a number called Target Sum.
 * I/P: int[] arr = {1,1,2,3}; int SUM = 1;

  <p>
      Approach: From given array elements we can have fallowing pattern which will give 1 on adding them
          a) +1 -1 -2 +3,
          b) -1 +1 -2 +3,
          c) +1 +1 +2 -3.
      If we add each expression individually will result 1.
  </p>
  Solution: It is basically the same problem as to Count the Subsets where the difference of sum of elements in each subset
  will be a given number.
 */
public class TargetSum {

    public static void main(String[] args) {

        // Given
        int[] arr = {1,1,2,3};
        int SUM = 1;

        int R = Arrays.stream(arr).sum();
        int s1 = (1 + R) / 2;

        int n = arr.length;
        int[][] t = new int[n + 1][s1 + 1];

        int numberOfSubsets = SubsetSumCountForGIvenDifference.countNumberOfSubsets(arr, n, s1, t);
        System.out.format("Total number of subsets is - %s where the Target Sum is %s.", numberOfSubsets, SUM);
    }
}
