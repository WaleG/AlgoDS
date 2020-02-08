package com.example.dynamicprogramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int result = new LongestCommonSubsequence().longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    //bottom-up DP
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    memo[i + 1][j + 1] = 1 + memo[i][j];
                } else {
                    memo[i + 1][j + 1] = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
            }
        }
        return memo[text1.length()][text2.length()];
    }

//    //Bottom-up DP
//    public int longestCommonSubsequence(String text1, String text2) {
//        if (text1 == null || text2 == null) return 0;
//        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
//        return lcs(text1.toCharArray(), text1.length(), text2.toCharArray(), text2.length(), memo);
//    }
//
//    private int lcs(char[] s1, int l1, char[] s2, int l2, int[][] memo) {
//        if (l1 == 0 || l2 == 0) {
//            return 0;
//        }
//        if (memo[l1][l2] != 0) return memo[l1][l2];
//        if (s1[l1 - 1] == s2[l2 - 1]) {
//            memo[l1][l2] = 1 + lcs(s1, l1 - 1, s2, l2 - 1, memo);
//        } else {
//            memo[l1][l2] = Math.max(lcs(s1, l1 - 1, s2, l2, memo), lcs(s1, l1, s2, l2 - 1, memo));
//        }
//        return memo[l1][l2];
//    }
}
