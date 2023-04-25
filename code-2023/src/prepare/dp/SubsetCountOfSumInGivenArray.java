package prepare.dp;

/**
 * Program to find the count of all possible subsets of a given array whose element's sum is equal to a given number.
 */
public class SubsetCountOfSumInGivenArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        // Sum of elements should be
        int k = 10;
        int n = arr.length;
        int[][] t = new int[n + 1][k + 1];

        int subsets = countSubsets(arr, n, k, t);
        System.out.format("Total subsets of given array with sum %s is : %s", k, subsets);
        System.out.println();
        printArray(k, n, t);
    }

    private static int countSubsets(int[] arr, int n, int k, int[][] t) {
        // Initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                if (j == 0)
                    t[i][j] = 1;
            }
        }
        // printArray(k, n, t);

        // Choice Diagram logic code.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j] + t[i-1][j - arr[i - 1]];
                else if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
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
