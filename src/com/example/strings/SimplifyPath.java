package com.example.strings;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String test = "/a//b////c/d//././/..";
        String result = new SimplifyPath().simplifyPath(test);
        System.out.println(result);
    }

    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String str : strings) {
            if (!str.isEmpty() && !str.equals(".")) {
                if (!str.equals("..")) {
                    stack.push(str);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }

        if (sb.length() == 0) {
            sb.append("/");
        }

        return sb.toString();
    }
}
