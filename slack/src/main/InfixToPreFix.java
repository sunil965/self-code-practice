package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InfixToPreFix {
    public static void main(String[] args) {
        String infix = "((2+3)*4-5)*6";
        System.out.println("Output is : " + convertToPrefix(infix));
    }

    private static String convertToPrefix(String infix) {
       char[] chars = infix.toCharArray();
       ArrayList<Character> al = new ArrayList<>();
         Collections.reverse(al);


        return null;
    }
}
