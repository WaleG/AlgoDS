package com.example.ignore.uber;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = new ValidParentheses().isValid("(({))}");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> left = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left.push(c);
            } else if (left.isEmpty() || map.get(left.pop()) != c) {
                return false;
            }
        }

        return left.isEmpty();
    }
}
