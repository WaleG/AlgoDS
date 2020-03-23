package com.example.ignore.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[{}]";
        boolean isValid = new ValidParentheses().isValid(s);
        System.out.println(isValid);
    }

    public boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');
        Stack<Character> notClosed = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) notClosed.push(c);
            else if (notClosed.isEmpty() || pairs.get(notClosed.pop()) != c) return false;
        }
        return notClosed.isEmpty();
    }
}
