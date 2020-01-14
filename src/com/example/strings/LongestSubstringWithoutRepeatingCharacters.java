package com.example.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        int r = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s);
        System.out.println(r);
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        int n = s.length();
        int maxLength = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (seen.containsKey(s.charAt(j))) {
                i = Math.max(i, seen.get(s.charAt(j)) + 1);
            }
            seen.put(s.charAt(j), j);
            j++;
            maxLength = Math.max(maxLength, j - i);
        }
        return maxLength;
    }
}
