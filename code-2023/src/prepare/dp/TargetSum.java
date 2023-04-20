package prepare.dp;

/**
 * Problem: To place "+" OR "-" in a way between the elements of a given array so that the Sum of all elements with
 * the symbol will be equal to a number called Target Sum.
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
        // TODO: Same as Count Subset Sum for a Given Difference.
    }
}
