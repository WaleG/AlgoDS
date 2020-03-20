package com.example.strings;

import java.util.Stack;

public class DecodeString {
    /*
     * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */

    public String decodeString(String s) {
        Stack<Integer> multipliers = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        strings.push(new StringBuilder());
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                k = k * 10 + Character.getNumericValue(c);
            } else if (c == '[') {
                multipliers.push(k);
                k = 0;
                strings.push(new StringBuilder());
            } else if (c == ']') {
                StringBuilder strToMultiply = strings.pop();
                StringBuilder concatenated = new StringBuilder();
                int times = multipliers.pop();
                for (int j = 0; j < times; j++) {
                    concatenated.append(strToMultiply);
                }
                strings.push(strings.pop().append(concatenated));
            } else {
                strings.push(strings.pop().append(c));
            }
        }

        return strings.pop().toString();
    }
}
