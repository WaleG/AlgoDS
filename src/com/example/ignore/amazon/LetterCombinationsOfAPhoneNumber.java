package com.example.ignore.amazon;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        generate(digits, 0, map, result, new StringBuilder());
        return result;
    }

    private void generate(
            String digits,
            int i,
            Map<Character, List<Character>> map,
            List<String> result,
            StringBuilder sb
    ) {
        if (i == digits.length()) {
            result.add(sb.toString());
        } else {
            for (char c : map.get(digits.charAt(i))) {
                sb.append(c);
                generate(digits, i + 1, map, result, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
