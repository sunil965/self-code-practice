package main;

import java.util.*;

public class InfixToPreFix {
    public static void main(String[] args) {
        String infix = "((2+3)*4-5)*6";
        System.out.println("Input :" + infix);
        System.out.println("Output is : " + convertToPrefix(infix));
    }

    private static String convertToPrefix(String infix) {
        char[] chars = new String(new StringBuilder(infix).reverse()).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(')
                chars[i] = ')';
            else if (chars[i] == ')') {
                chars[i] = '(';
            }
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ' || aChar == ',')
                continue;
            if (Character.isLetterOrDigit(aChar)) {
                builder.append(aChar);
            } else if (isOperator(aChar)) {
                // Pop higher precedence operator till stack is not empty or having closing round bracket.
                while (!stack.isEmpty() && stack.peek() != '(' && higherPrecedence(stack.peek(), aChar)) {
                    builder.append(stack.pop());
                }
                stack.push(aChar);
            } else if (aChar == '(') {
                stack.push(aChar);
            } else if (aChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty() && isOperator(stack.peek())) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    private static boolean isOperator(char aChar) {
        return aChar == '+' || aChar == '-' || aChar == '*' || aChar == '/';
    }

    private static boolean higherPrecedence(Character peek, char c) {
        int op1Weight = getOperatorWeight(peek);
        int op2Weight = getOperatorWeight(c);

        // If operators have equal precedence, return true if they are left associative.
        // return false, if right associative.
        // if operator is left-associative, left one should be given priority.
        if (op1Weight == op2Weight) {
            return !isRightAssociative(peek);
        }
        return op1Weight > op2Weight;
    }

    private static boolean isRightAssociative(Character peek) {
        return peek == '$';
    }

    private static int getOperatorWeight(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '$' -> 3;
            default -> -1;
        };
    }

    private static boolean isLowPrecedence(Character peek, char aChar) {
        return false;
    }
}
