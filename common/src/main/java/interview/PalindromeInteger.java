package interview;

public class PalindromeInteger {

    public static void main(String[] args) {
        int inputNumber = 12321;
        int givenNumber = inputNumber;
        int reverseNumber = 0;
        int remainder;

        System.out.println("Given Number : " + givenNumber);

        while (inputNumber > 0) {
            remainder = inputNumber % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            inputNumber = inputNumber / 10;
        }
        System.out.println("Reversed Number : " + reverseNumber);

        if (givenNumber == reverseNumber)
            System.out.println("Given number is palindrome number");
        else
            System.out.println("Given number is not a palindrome.");
    }
}
