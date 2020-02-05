package com.example.dynamicprogramming;

public class DecodeWays {
    public static void main(String[] args) {
        String test = "12";
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings(test));
    }

    public int numDecodings(String s) {
        return countDecoding(s.toCharArray(), s.length());
    }

    private int countDecoding(char[] chars, int n) {
        if (chars[0] == '0') return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (chars[i - 1] > '0') {
                dp[i] = dp[i - 1];
            }
            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (chars[i - 2] == '1' || chars[i - 2] == '2' && chars[i - 1] < '7') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
//// recursive
//    public int numDecodings(String s) {
//        if (s == null || s.equals("0")) return 0;
//        return countDecoding(s.toCharArray(), s.length());
//    }
//
//    private int countDecoding(char[] chars, int n) {
//        if (n == 0 || n == 1) return 1;
//        if (chars[0] == '0') return 0;
//
//        int count = 0;
//        if (chars[n - 1] > '0') {
//            count = countDecoding(chars, n - 1);
//        }
//        if (chars[n - 2] == '1' || chars[n - 2] == '2' && chars[n - 1] < '7') {
//            count += countDecoding(chars, n - 2);
//        }
//        return count;
//    }
}
