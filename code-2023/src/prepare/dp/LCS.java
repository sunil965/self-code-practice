package prepare.dp;

/**
 * Longest common subsequence between two String is the number of characters with their count is same,
 * order of the characters does not matter.
 * String s1 = "sunil";
 * String s2 = "kumar";
 * In the above string the LCS of s1, s2 is 1 because only 'u' is common in them if we change the position
 * or increase the count of 'u' in any of the string the LCS will remain same.
 */

public class LCS {

    static int[][] t = new int[10][10];

    static void printMatrix(int[][] t) {
        for (int[] r : t) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        String s1 = "sunil";
        String s2 = "kumar";
        int m = s1.length();
        int n = s2.length();

        // Longest common subsequence Recursive
        int longestCommonSubsequenceRecursion = longestCommonSubsequenceRecursion(s1, s2, m, n);
        System.out.println("Recursive : Longest common subsequence size : " + longestCommonSubsequenceRecursion);

        // Longest common subsequence MemoizeDP
        int longestCommonSubsequenceMemoizeDp = longestCommonSubsequenceMemoizeDp(s1, s2, m, n);
        System.out.println("MemoizeDP : Longest common subsequence size : " + longestCommonSubsequenceMemoizeDp);
//        printMatrix(t);

        // Longest common subsequence real DP without Recursion
        /*
            int longestCommonSubsequenceDp = longestCommonSubsequenceDp(s1, s2, m, n);
            System.out.println("DP : Longest common subsequence size : " + longestCommonSubsequenceDp);
        */
        longestCommonSubsequenceDp(s1, s2, m, n);
    }

    public static void longestCommonSubsequenceDp(String s1, String s2, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        // By default value of matrix is assigned with zero, no need to initialize 1st row & 1st column.

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
//        return t[m][n];
        System.out.println("DP : Longest common subsequence size : " + t[m][n]);
        printMatrix(t);
    }

    public static int longestCommonSubsequenceMemoizeDp(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (t[m][n] != 0)
            return t[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return t[m][n] = 1 + longestCommonSubsequenceMemoizeDp(s1, s2, m - 1, n - 1);
        else
            return t[m][n] = Math.max(
                    longestCommonSubsequenceMemoizeDp(s1, s2, m - 1, n), longestCommonSubsequenceMemoizeDp(s1, s2, m, n - 1)
            );
    }

    private static int longestCommonSubsequenceRecursion(String s1, String s2, int m, int n) {
        // Base Condition
        if (m == 0 || n == 0)
            return 0;

        // Choice selection/diagram
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + longestCommonSubsequenceRecursion(s1, s2, m - 1, n - 1);
        else
            return Math.max(
                    longestCommonSubsequenceRecursion(s1, s2, m - 1, n), longestCommonSubsequenceRecursion(s1, s2, m, n - 1)
            );
    }
}
