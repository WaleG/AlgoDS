package com.example.strings;

import java.util.ArrayList;
import java.util.List;

public class KnuthMorrisPratt {

    public static void main(String[] args) {
        String txt = "hello therel";
        String pat = "el";
        if (search(pat, txt).contains(10)) System.out.println("Right!");
        else System.out.println("Wrong!");
    }

    public static List<Integer> search(String pattern, String text) {
        List<Integer> result = new ArrayList<>();
        int M = pattern.length();
        int N = text.length();

        int[] lps = new int[M];
        computeLongestPrefixSuffix(pattern, lps);
        int i = 0, j = 0;

        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == M) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }

        return result;
    }

    private static void computeLongestPrefixSuffix(String pattern, int[] lps) {
        int M = pattern.length();
        int i = 1;
        int len = 0;
        lps[0] = 0;

        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) len = lps[len - 1];
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
