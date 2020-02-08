package com.example.arrays;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int maxLength = 1;
        int j = 0;
        while (j++ < n - 1) {
            int length = 1;
            while (j < n && nums[j] > nums[j - 1]) {
                length++;
                maxLength = Math.max(length, maxLength);
                j++;
            }
        }
        return maxLength;
    }
}
