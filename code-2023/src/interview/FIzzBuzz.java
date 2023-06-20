package interview;

import java.util.stream.IntStream;

public class FIzzBuzz {
    public static void main(String[] args) {

        int end = 50;

        IntStream.range(1,end).mapToObj(value -> value % 3 == 0 ? (value % 5 == 0 ? "FizzBuzz" : "Fizz") :(value % 5 == 0 ? "Buzz": value)).forEach(System.out::println);
    }
}
