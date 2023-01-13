package main;

import java.util.Stack;

public class InfixToPreFix2 {
    static int precedence(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static StringBuilder infixToPreFix(String expression) {

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<>();

        char[] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {

            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            } else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }
        for (char c : charsExp) {
            //check if char is operator or operand
            if (precedence(c) > 0) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result.append(x);
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                //character is neither operator nor "("
                result.append(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() != '(')
                result.append(stack.pop());
            else
                stack.pop();
        }
        return result.reverse();
    }

    public static void main(String[] args) {
        String exp = "((2+3)*4-5)*6";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + infixToPreFix(exp));
    }
}
