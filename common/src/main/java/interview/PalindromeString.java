package interview;

public class PalindromeString {
    public static void main(String[] args) {

        String str = "RadaR";

        basicApproach(str);

        secondApproach(str);
    }

    private static void secondApproach(String str) {
        int n = str.length();
        if (checkPalindrome(str.toLowerCase(), n))
            System.out.print("Given string is palindrome");
        else
            System.out.print("Given string is not palindrome");
    }

    private static void basicApproach(String str) {
        StringBuilder reverseString = new StringBuilder();

        int strLength = str.length();

        for (int i = (strLength - 1); i >= 0; --i) {
            reverseString.append(str.charAt(i));
        }

        if (str.equalsIgnoreCase(reverseString.toString())) {
            System.out.println(str + " is a Palindrome String.");
        } else {
            System.out.println(str + " is not a Palindrome String.");
        }
    }

    private static boolean checkPalindrome(String str, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
