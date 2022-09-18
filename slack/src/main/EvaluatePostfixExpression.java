package main;

import java.util.Stack;

/*
  Evaluation Of postfix Expression in Java. Input Postfix expression must be in a desired format.
*/

public class EvaluatePostfixExpression {

    public static void main(String[] args) {
        String exp = "2 3 * 5 4 * + 9 -";
        System.out.println("Answer of Postfix Expression  is " + evaluatePostfixExpression(exp));
    }

    private static int evaluatePostfixExpression(String exp) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = exp.toCharArray();
        int op1, op2;
        for (int i = 0; i < exp.length(); i++) {
            if (arr[i] == ' ' || arr[i] == ',')
                continue;

            if (arr[i] == '/' || arr[i] == '*' || arr[i] == '+' || arr[i] == '-') {
                op2 = stack.pop();
                op1 = stack.pop();
                stack.push(operation(arr[i], op1, op2));
            } else if (isANumber(arr[i])) {
                int operand = 0;
                while (i < exp.length() && isANumber(arr[i])) {
                    // For a number with more than one digit, as we are scanning from left to right.
                    // Everytime , we get a digit towards right, we can multiply current total in operand by 10
                    // and add the new digit.
                    operand = (operand * 10) + (arr[i] - '0'); // arr[i] - '0' is just a way to convert from char to int.
                    i++;
                }
                // Finally, you will come out of while loop with i set to a non-numeric character or end of string
                // decrement i because it will be incremented in increment section of loop once again.
                // We do not want to skip the non-numeric character by incrementing i twice.
                i--;
                stack.push(operand);
            }
        }
        return stack.pop();
    }

    private static boolean isANumber(char c) {
        return '0' <= c && '9' >= c;
    }

    static int operation(char operator, int op1, int op2) {
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
