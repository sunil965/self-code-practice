package prepare.dp.unbound_knapsack;

/**
 * Find Maximum number of ways to select coins from an array whose sum is equal to a given Number.
 * Given Input:
 * int[] coins = {1,2,3};
 * int sum = 5;
 * Here possible combination of coins whose sum is 5 could be-
 * {2,3}, {1,2,2}, {1,1,3}, {1,1,1,2}, {1,1,1,1,1} : Same coin is used multiple time as Unbounded Knapsack.
 * Here we have 5 ways to create a subset where sum of elements is 5 so answer is 5.
 */
public class CoinChangeMaxWay {

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
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coins[i - 1] <= j)
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                else if (coins[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        System.out.format("Number of ways :%s", t[n][sum]);
    }
}
