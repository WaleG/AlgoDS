package com.example.ignore.amazon;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbabdbdabd";
        int len = new LongestPalindromicSubsequence().longestPalindromeSubseq(s);
        System.out.println(len);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
