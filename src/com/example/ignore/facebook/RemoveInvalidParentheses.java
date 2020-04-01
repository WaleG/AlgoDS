package com.example.ignore.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    /*
    Remove the minimum number of invalid parentheses in order to make the input string valid.
    Return all possible results.

    Note: The input string may contain letters other than the parentheses ( and ).

    Example 1:

    Input: "()())()"
    Output: ["()()()", "(())()"]
    Example 2:

    Input: "(a)())()"
    Output: ["(a)()()", "(a())()"]
    Example 3:

    Input: ")("
    Output: [""]
     */

    public static void main(String[] args) {
        RemoveInvalidParentheses rm = new RemoveInvalidParentheses();

        String s1 = "()())()";
        System.out.println(rm.removeInvalidParentheses(s1));

        String s2 = "(a)())()";
        System.out.println(rm.removeInvalidParentheses(s2));

        String s3 = ")(";
        System.out.println(rm.removeInvalidParentheses(s3));
    }

    public List<String> removeInvalidParentheses(String s) {
        int removeLeft = 0;
        int removeRight = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                removeLeft++;
            } else if (c == ')') {
                if (removeLeft > 0) removeLeft--;
                else removeRight++;
            }
        }

        Set<String> result = new HashSet<>();
        dfs(new StringBuilder(), 0, removeLeft, removeRight, s, result, 0);
        return new ArrayList<>(result);
    }

    private void dfs(
            StringBuilder currentExp,
            int i,
            int removeLeft,
            int removeRight,
            String s,
            Set<String> validExp,
            int open
    ) {
        if (removeLeft < 0 || removeRight < 0 || open < 0) return;
        if (i == s.length()) {
            if (removeLeft == 0 && removeRight == 0 && open == 0) {
                validExp.add(currentExp.toString());
            }
        } else {
            char c = s.charAt(i);
            if (c == '(') {
                dfs(currentExp, i + 1, removeLeft - 1, removeRight, s, validExp, open); // don't use '('
                dfs(currentExp.append(c), i + 1, removeLeft, removeRight, s, validExp, open + 1); // use '('
            } else if (c == ')') {
                dfs(currentExp, i + 1, removeLeft, removeRight - 1, s, validExp, open); // don't use ')'
                dfs(currentExp.append(c), i + 1, removeLeft, removeRight, s, validExp, open - 1); // use ')'
            } else {
                dfs(currentExp.append(c), i + 1, removeLeft, removeRight, s, validExp, open);
            }
            currentExp.deleteCharAt(currentExp.length() - 1);
        }
    }
}
