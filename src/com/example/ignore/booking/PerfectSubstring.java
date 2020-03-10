package com.example.ignore.booking;

public class PerfectSubstring {
    public static int perfectSubstring(String s, int k) {
        int count = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if (isPerfectSubstring(s, start, end, k)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPerfectSubstring(String s, int from, int to, int k) {
        int[] frequency = new int[10];
        for (int i = from; i <= to; i++) {
            int number = s.charAt(i) - '0';
            frequency[number]++;
        }
        for (int i = 0; i < 10; i++) {
            if (frequency[i] != 0 && frequency[i] != k) {
                return false;
            }
        }
        return true;
    }
}
