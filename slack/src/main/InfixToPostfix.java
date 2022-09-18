package main;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "((2+3)*4-5)*6";
        System.out.println("Output is : " + convertToPostfix(infix));
    }

    private static String convertToPostfix(String infix) {
        char[] chars = infix.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < infix.length(); i++) {
            if (chars[i] == ' ' || chars[i] == ',') continue;

            if (isAnOperator(chars[i])) {
                // Pop higher precedence operator till stack is not empty or having closing round bracket.
                while (!stack.isEmpty() && stack.peek() != '(' && higherPrecedence(stack.peek(), chars[i])) {
                    sb.append(stack.pop());
                }
                stack.push(chars[i]);
            }
            // Else if character is an operand
            else if (isAnAlphabetOrNumber(chars[i])) {
                sb.append(chars[i]);
            } else if (chars[i] == '(') {
                stack.push(chars[i]);
            } else if (chars[i] == ')') {
                while (!stack.empty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
        }

        // To get any operator left in stack.
        while (!stack.isEmpty() && isAnOperator(stack.peek())) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static boolean isAnOperator(char c) {
        return c == '/' || c == '*' || c == '+' || c == '-' || c == '$';
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
        int weight = -1;
        switch (op) {
            case '+':
            case '-':
                weight = 1;
                break;
            case '*':
            case '/':
                weight = 2;
                break;
            case '$':
                weight = 3;
                break;
        }
        return weight;
    }

    private static boolean isAnAlphabetOrNumber(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
