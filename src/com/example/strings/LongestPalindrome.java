package com.example.strings;

public class LongestPalindrome {
    //  Expand around center
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        String longest = "";
        String cand1;
        String cand2;
        for (int i = 0; i < s.length(); i++) {
            cand1 = lp(s, i, i);
            cand2 = lp(s, i, i + 1);
            cand1 = cand1.length() > cand2.length() ? cand1 : cand2;
            longest = cand1.length() > longest.length() ? cand1 : longest;
        }
        return longest;
    }

    private String lp(String s, int l, int r) {
        int lb = l;
        int rb = l;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) return s.substring(lb, rb + 1);
            lb = l--;
            rb = r++;
        }
        return s.substring(lb, rb + 1);
    }
}
