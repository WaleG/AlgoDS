package com.example.strings;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int operand = 0;
        int result = 0; //result of a sub-expression
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {

                operand = operand * 10 + (c - '0');

            } else if (c == '+') {

                result += sign * operand;
                sign = 1;
                operand = 0;

            } else if (c == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (c == '(') {

                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;

            } else if (c == ')') {

                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();

                operand = 0;
            }
        }

        return result + (sign * operand);
    }
}
