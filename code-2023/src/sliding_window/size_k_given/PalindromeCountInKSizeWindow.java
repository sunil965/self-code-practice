package sliding_window.size_k_given;

/**
 * Given string str consists of only lowercase alphabets and an integer K, the task is to count the number of substrings
 * of size K such that any permutation of the substring is a palindrome.

 * This problem can be solved efficiently by using the Window Sliding Technique and using a frequency array of size 26.
 * Below are the steps:
 * 1) Store the frequency of the first K elements of the given string in a frequency array(say freq[]).
 * 2) Using a frequency array, check the count of elements having an odd frequency. If it is less than 2,
 *    then the increment of the count of palindromic permutation.
 * 3) Now, linearly slide the window ahead till it reaches the end.
 * 4) At each iteration, decrease the count of the first element of the window by 1 and increase the count
 *    of the next element of the window by 1 and again check the count of elements in a frequency array having an odd
 *    frequency. If it is less than 2, then increase the count of the palindromic permutation.
 * 5)Repeat the above step till we reach the end of the string and print the count of palindromic permutation.
 */
public class PalindromeCountInKSizeWindow {

    public static void main(String[] args) {
        String givenString = "aabcbaa";
        int k = 3;

        System.out.print(countPalindromePermutation(givenString.toCharArray(), k));
    }

    // To store the frequency array
    static int[] freq = new int[26];

    // Function to check palindromic of any subString using frequency array
    static boolean checkPalindrome() {

        // Initialise the odd count
        int oddCnt = 0;

        // Traversing frequency array to compute the count of characters having odd frequency
        for (int x : freq) {
            if (x % 2 == 1)
                oddCnt++;
        }
        // Returns true if odd count is at-most 1
        return oddCnt <= 1;
    }


    private static int countPalindromePermutation(char[] s, int k) {
        // Computing the frequency of first K character of the String
        for (int i = 0; i < k; i++) {
            freq[s[i] - 97]++;
        }

        // To store the count of palindromic permutations
        int ans = 0;

        // Checking for the current window if it has any palindromic permutation
        if (checkPalindrome()) {
            ans++;
        }

        // Start and end point of window
        int i = 0, j = k;

        while (j < s.length) {

            // Sliding window by 1

            // Decrementing count of first element of the window
            freq[s[i++] - 97]--;

            // Incrementing count of next element of the window
            freq[s[j++] - 97]++;

            // Checking current window character frequency count
            if (checkPalindrome()) {
                ans++;
            }
        }

        // Return the final count
        return ans;
    }
}
