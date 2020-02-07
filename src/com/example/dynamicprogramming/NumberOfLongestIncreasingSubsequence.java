package com.example.dynamicprogramming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 7};
        int number = new NumberOfLongestIncreasingSubsequence().lengthOfLIS(a);
        System.out.println(number);
    }

    //bottom-up DP
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] counts = new int[n];
        Arrays.fill(counts, 1);

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    if (dp[i] >= dp[j]) {
                        dp[j] = dp[i] + 1;
                        counts[j] = counts[i];
                    } else if (dp[i] + 1 == dp[j]) {
                        counts[j] += counts[i];
                    }
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int longest = 0;

        for (int length : dp) {
            longest = Math.max(longest, length);
        }

        int number = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == longest) {
                number += counts[i];
            }
        }
        return number;
    }
}
