package com.example.ignore.facebook;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        boolean[] remove = new boolean[s.length()];
        markCloseToRemove(s, remove);
        markOpenToRemove(s, remove);
        return removeInvalidParentheses(s, remove);
    }

    private void markCloseToRemove(String s, boolean[] remove) {
        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount > 0) openCount--;
                else remove[i] = true;
            }
        }
    }

    private void markOpenToRemove(String s, boolean[] remove) {
        int closeCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                closeCount++;
            } else if (c == '(') {
                if (closeCount > 0) closeCount--;
                else remove[i] = true;
            }
        }
    }

    private String removeInvalidParentheses(String s, boolean[] remove) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) result.append(s.charAt(i));
        }
        return result.toString();
    }
}
