package com.example.ignore.uber;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> res = new GenerateParentheses().generateParenthesis(3);
        System.out.println(res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, new StringBuilder(), result, n + n);
        return result;
    }

    private void generate(int start, int end, StringBuilder sb, List<String> result, int len) {
        if (sb.length() == len) {
            result.add(sb.toString());
        }
        if (start > 0) {
            sb.append("(");
            generate(start - 1, end, sb, result, len);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (end > start) {
            sb.append(")");
            generate(start, end - 1, sb, result, len);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
