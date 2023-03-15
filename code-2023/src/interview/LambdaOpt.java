package interview;

interface Arithmetic {
    int operation(int a, int b);
}

interface EvenOdd {
    String check(int number);
}

public class LambdaOpt {

    public static void main(String[] args) {
        Arithmetic multiply = (i, j) -> (i * j);
        System.out.println("Multiplication " + multiply.operation(2, 3));

        EvenOdd evenOdd = (int number) -> {
            if (number % 2 == 0)
                return "Even";
            else
                return "Odd";
        };

        System.out.println("Number is " + evenOdd.check(10));
    }
}
