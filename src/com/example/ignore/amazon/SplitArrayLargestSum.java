package com.example.ignore.amazon;

public class SplitArrayLargestSum {
    /*
    Given an array which consists of non-negative integers and an integer m,
    you can split the array into m non-empty continuous subarrays.
    Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
     */
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
//        int[] nums = {1, 2147483647};
        int result = new SplitArrayLargestSum().splitArray(nums, 2);
        System.out.println(result);
    }

    public int splitArray(int[] nums, int m) {
        int[][] memo = new int[nums.length][m + 1];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        return helper(nums, nums.length - 1, m, sum, memo);
    }

    private int helper(int[] nums, int start, int m, int[] sums, int[][] memo) {
        if (m == 1) {
            return sums[start];
        }
        if (memo[start][m] > 0) {
            return memo[start][m];
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = start; i >= 1; i--) {
            sum += nums[i];
            min = Math.min(Math.max(sum, helper(nums, i - 1, m - 1, sums, memo)), min);
        }
        memo[start][m] = min;
        return memo[start][m];
    }
}
