package com.example.dynamicprogramming;

public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0 , nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int from, int to) {
        int[] cache = new int[to];
        cache[from] = nums[from];
        cache[from + 1] = Math.max(nums[from], nums[from + 1]);
        for (int i = from + 2; i < to; i++) {
            cache[i] = Math.max(cache[i - 1], cache[i - 2] + nums[i]);
        }
        return cache[to - 1];
    }
}
