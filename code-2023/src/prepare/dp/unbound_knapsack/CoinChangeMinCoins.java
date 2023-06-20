package prepare.dp.unbound_knapsack;

/**
 * Find a Subset with Minimum number of Coins among all possible subsets from an array where sum of elements is equal
 * to a given Number.
 * Given Input:
 * int[] coins = {1,2,3};
 * int sum = 5;
 * Here possible combination of coins whose sum is 5 could be-
 * {2,3}, {1,2,2}, {1,1,3}, {1,1,1,2}, {1,1,1,1,1} : Among all these subsets {2,3} is having minimum coins(2).
 * Hence, answer will be 2.
 */
public class CoinChangeMinCoins {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;

        int n = coins.length;
        int[][] t = new int[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                // At j=0 the sum is 0 so no matter how many coins we have if we don't pick any coin then we will get an empty array
                // and the sum of an elements of an empty array will always 0. So the 1st column of matrix will be filled by 1.
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        // Choice logic code
    }
}
