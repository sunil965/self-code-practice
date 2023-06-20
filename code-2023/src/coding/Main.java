package org.example;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String strr = "JAVA";
        Map<String, Long> collect = Arrays.stream(strr.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(collect);

        String str = "aabcbaa";
        int k = 3;
        int n = str.length();
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                temp = str.substring(i, j);
                if ((j - i >= 3) && checkPalindrome(temp)) {
                    System.out.println(temp);
                }
            }
        }
    }

    private static boolean checkPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt((n - 1) - i))
                return false;
        }
        return true;
    }
}