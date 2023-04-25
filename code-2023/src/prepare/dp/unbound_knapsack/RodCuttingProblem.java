package prepare.dp.unbound_knapsack;

import java.util.Arrays;

/**
 * A rod of length 8 is given. The Prices array contain price of respective length of rod from Lengths array
 * with respect to their index. Cut the given rod in different pieces so that the price can be maximized.
 * Solution:
 * It is same as to the 01 Knapsack problem but the basic difference while choosing the item from Weight array
 * differs as in if an item is considered once it can be considered again. Means multiple occurrences of same item
 * is valid in Unbounded Knapsack.
 * Choice logic code:
 *  t[i][j - lengths[i - 1]] = when item from weight array is considered we are not reducing 'i' as in case of 01 knapsack to i-1,
 *  t[i - 1][j] = when item from weight is not considered.
 */
public class RodCuttingProblem {

    public static void main(String[] args) {

        // Given Input
        int[] lengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;

        int n = lengths.length;
        int[][] t = new int[n + 1][rodLength + 1];

        // Initialization - By default the 2D array is filled by 0, so this step is needed if we need to
        // initialized with any other value instead of 0.
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(t[i], 0);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < rodLength + 1; j++) {
                if (lengths[i - 1] <= j)
                    t[i][j] = Math.max(prices[i - 1] + t[i][j - lengths[i - 1]], t[i - 1][j]);
                else if (lengths[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        printArray(rodLength, n, t);
        System.out.format("The maximum price by cutting the Rod of %s unit can be %s.", rodLength, t[n][rodLength]);

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
