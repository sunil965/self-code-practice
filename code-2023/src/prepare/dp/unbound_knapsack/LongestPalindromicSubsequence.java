package prepare.dp.unbound_knapsack;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String st = "ervervige";
        int n = st.length();

        /*
          The Longest Palindromic Subsequence = The Longest Common Subsequence of the given string and reverse of given string.
          As we are provided only with one String and to find LCS we need Two Strings that's why in place of 2nd String we can
          use Reverse of the Given String.
         */

        int longestPalindromicSubsequence = longestCommonSubsequence(st, new StringBuffer(st).reverse().toString(), n, n);
        System.out.println("Longest Palindromic Subsequence length : " + longestPalindromicSubsequence);

        /*
          No of character to be deleted to convert a Given String in Palindrome String. First find LCS between Given String & it's reverse
          of Given String then delete the length of LCS from the length of Given String.
         */

        int charToDelete = st.length() - longestPalindromicSubsequence;
        System.out.println("No of char to be deleted to make given string Palindromic is  : " + charToDelete);
    }

    private static int longestCommonSubsequence(String st1, String st2, int m, int n) {
        // By default value of matrix is assigned with zero, no need to initialize 1st row & 1st column.
        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (st1.charAt(i - 1) == st2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }
        return t[m][n];
    }
}
