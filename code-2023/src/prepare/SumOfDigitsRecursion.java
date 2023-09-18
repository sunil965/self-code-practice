package prepare;

public class SumOfDigitsRecursion {

    public static void main(String[] args) {
        //Calling sumOfDigits method
        int result = sumOfDigits(1234);

        //Print result
        System.out.println(result);
    }

    private static int sumOfDigits(int num) {
        if (num == 0)
            return 0;
        return num % 10 + sumOfDigits(num / 10);
    }
}
