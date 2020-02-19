package com.example.strings;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindromes(s, i, i);
            count += countPalindromes(s, i, i + 1);
        }
        return count;
    }

    private int countPalindromes(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) {
            count++;
        }
        return count;
    }
}
