package com.example.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    //bottom-up DP
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxSoFar = 1;
        for (int j = 1; j < n; j++) {
            int i = 0;
            while (i < j) {
                if (nums[j] > nums[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
                i++;
            }
            maxSoFar = Math.max(maxSoFar, dp[j]);
        }
        return maxSoFar;
    }

//    //    recursive
//    public int -lengthOfLIS(int[] nums) {
//        return maxLIS(nums, Integer.MIN_VALUE, 0);
//    }
//
//    private int maxLIS(int[] nums, int prevMin, int i) {
//        if (i == nums.length) {
//            return 0;
//        }
//        int take = 0;
//        if (nums[i] > prevMin) {
//            take = 1 + maxLIS(nums, nums[i], i + 1);
//        }
//        int skip = maxLIS(nums, prevMin, i + 1);
//        return Math.max(take, skip);
//    }
}
