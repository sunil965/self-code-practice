package prepare.dp;

/**
 * Program to check if the given array has a subset/subarray whose element's sum is equal to a given number.
 * Input : int[] arr = {2,3,7,8,10};
 * int K = 11;
 * Output: TRUE/FALSE (For given Array O/P is TRUE as Sub array = {3, 8} exist and its sum is 11)
 */
public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int K = 11;
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][K + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < K; j++) {
                if (i == 0)
                    t[i][j] = false;
                if (j == 0)
                    t[i][j] = true;
            }
        }

        System.out.println("****************** Array After Initialization ******************");
        printArray(K, n, t);

        checkSubSetForGIvenSum(arr, K, n, t);

        System.out.println("****************** Array After Subset Check *********************");
        printArray(K, n, t);

        System.out.println("**************************** Result *****************************");
        System.out.format("Subset Exist : %s", t[n][K]);

    }

    private static void checkSubSetForGIvenSum(int[] arr, int K, int n, boolean[][] t) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i][j - arr[i - 1]] || t[i - 1][j];
                else if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
    }

    private static void printArray(int K, int n, boolean[][] t) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
