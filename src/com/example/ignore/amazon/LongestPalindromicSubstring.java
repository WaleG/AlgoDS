package com.example.ignore.amazon;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int[] longest = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            int[] c1 = longestPalindrome(s, i, i);
            int[] c2 = longestPalindrome(s, i, i + 1);
            longest = longest(c1, longest);
            longest = longest(c2, longest);
        }
        return s.substring(longest[0], longest[1] + 1);
    }

    private int[] longestPalindrome(String s, int l, int r) {
        int lb = l;
        int rb = r;
        while (lb >= 0 && rb < s.length() && s.charAt(lb) == s.charAt(rb)) {
            lb--;
            rb++;
        }
        return new int[]{lb + 1, rb - 1};
    }

    private int[] longest(int[] c1, int[] c2) {
        if (c1[1] - c1[0] > c2[1] - c2[0]) {
            return c1;
        } else {
            return c2;
        }
    }
}
