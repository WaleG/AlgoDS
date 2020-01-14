package com.example.strings;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')' && (stack.isEmpty() || stack.pop() != '('))
                return false;
            else if (c == '}' && (stack.isEmpty() || stack.pop() != '{'))
                return false;
            else if (c == ']' && (stack.isEmpty() || stack.pop() != '['))
                return false;
        }
        return stack.isEmpty();
    }
}