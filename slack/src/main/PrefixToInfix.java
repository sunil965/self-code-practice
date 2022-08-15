package main;

import java.util.Stack;

/*
  Evaluation Of prefix Expression in Java. Input Prefix expression must be in a desired format.
*/

public class PrefixToInfix {
    public static void main(String[] args) {
        String exp = "- + 7 * 4 5 + 2 0";
        System.out.println("Answer of Prefix Expression  is " + evaluateExpression(exp));
    }

    private static int evaluateExpression(String exp) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = exp.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ' || chars[i] == ',')
                continue;

            if (chars[i] == '/' || chars[i] == '*' || chars[i] == '+' || chars[i] == '-') {
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(calculate(chars[i], op1, op2));
            } else if (isANumber(chars[i])) {
                int operand = 0;
                while (i < chars.length && isANumber(chars[i])) {
                    operand = (operand * 10) + (chars[i] - '0');
                    i--;
                }
                i++;
                stack.push(operand);
            }
        }
        return stack.pop();
    }

    private static boolean isANumber(char aChar) {
        return aChar >= '0' && aChar <= '9';
    }

    private static int calculate(char operator, int op1, int op2) {
        switch (operator) {
            case '/':
                return op1 / op2;
            case '*':
                return op1 * op2;
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
        }
        return 0;
    }
}
