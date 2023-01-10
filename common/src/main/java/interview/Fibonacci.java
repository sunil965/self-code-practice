package interview;

public class Fibonacci {

    public static void main(String[] args) {
        int n1 = 0, n2 = 1, n3, count = 10;

        // Basic Step
        System.out.print(n2);

        for (int i = 1; i < count; ++i) {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
        System.out.println();

        // Recursive Approach
        System.out.println("Recursive Approach " + fib(10));
    }

    private static int fib(int number) {
        if (number < 2)
            return number;
        else
            return (fib(number - 1) + fib(number - 2));
    }
}
