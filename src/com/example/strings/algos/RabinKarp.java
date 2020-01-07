package com.example.strings.algos;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {

    private static final int PRIME = 101;

    public static void main(String[] args) {
        String txt = "hello therell";
        String pat = "ll";
        if (search(pat.toCharArray(), txt.toCharArray()).contains(10)) System.out.println("Right!");
        else System.out.println("Wrong!");
    }

    public static List<Integer> search(char[] pattern, char[] text) {
        List<Integer> result = new ArrayList<>();
        int M = pattern.length;
        int N = text.length;
        long patternHash = generateHash(pattern, M);
        long textHash = generateHash(text, M);

        for (int i = 0; i <= N - M; i++) {
            if (patternHash == textHash && checkEqual(text, i, i + M, pattern, 0, M))
                result.add(i);
            if (i < N - M)
                textHash = rollingHash(text, i, i + M, textHash, M);
        }

        return result;
    }

    private static long generateHash(char[] str, int end) {
        long hash = 0;
        for (int i = 0; i < end; i++) {
            hash += str[i] * Math.pow(PRIME, i);
        }
        return hash;
    }

    private static long rollingHash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLen) {
        long newHash = oldHash - str[oldIndex];
        newHash /= PRIME;
        newHash += str[newIndex] * Math.pow(PRIME, patternLen - 1);
        return newHash;
    }

    private static boolean checkEqual(char[] str1, int start1, int end1, char[] str2, int start2, int end2) {
        if (end1 - start1 != end2 - start2) return false;

        while (start1 < end1 && start2 < end2) {
            if (str1[start1] != str2[start2]) return false;
            start1++;
            start2++;
        }

        return true;
    }
}
