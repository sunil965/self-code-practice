package interview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReplaceString {

    public static void main(String[] args) {

        String input = "sunilkumar@gmail.com";

        String collect = Arrays.stream(input.split(""))
                .filter(s -> !s.equals("@"))
                .collect(Collectors.joining(""));

        System.out.println(collect);
    }
}
