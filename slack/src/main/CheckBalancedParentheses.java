package main;

import java.util.Stack;

public class CheckBalancedParentheses {

    public static void main(String[] args) {
        String exp = "[{(A+B)}+{C/(D-E)}";
        checkExpression(exp);
    }

    private static void checkExpression(String exp) {
        Stack<Character> stack = new Stack<>();
        if (exp.length() == 0) {
            System.out.println("Expression is empty !!");
            return;
        }
        char[] c = exp.toCharArray();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '[') {
                stack.push(exp.charAt(i));
            } else if (exp.charAt(i) == ')' || exp.charAt(i) == '}' || exp.charAt(i) == ']') {
                if (!stack.empty() && arePair(stack.peek(), exp.charAt(i))) {
                    stack.pop();
                } else
                    stack.push(exp.charAt(i));
            }
        }
        System.out.println("Stack is " + stack);
        System.out.println("Expression is " + (stack.size() == 0 ? "BALANCE" : "UNBALANCE"));
    }

    private static boolean arePair(char b1, char b2) {
        if (b1 == '(' && b2 == ')')
            return true;
        else if (b1 == '{' && b2 == '}')
            return true;
        else return b1 == '[' && b2 == ']';
    }
}
