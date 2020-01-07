package com.example.strings;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || t.length() < s.length()) return false;
        int[] count = new int[128];
        int i;
        for (char c: s.toCharArray()) {
            i = c - '0';
            count[i]++;
        }
        for (char c: t.toCharArray()) {
            i = c - '0';
            count[i]--;
            if (count[i] < 0) return false;
        }
        for (int j: count) {
            if (j != 0) return false;
        }
        return true;
    }
}
