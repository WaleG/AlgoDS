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
        int[] nums = {7, 2, 5, 10, 8};
//        int[] nums = {1, 2147483647};
        int result = new SplitArrayLargestSum().splitArray(nums, 2);
        System.out.println(result);
    }

    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;

        //find sum of all elements and max element
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }

        if (m == 1) return (int) sum;

        //do binary search
        long l = max, r = sum;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (isValid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private boolean isValid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                count++;
                total = num;
                if (count > m) return false;
            }
        }
        return true;
    }

//    //top-down
//    public int splitArray(int[] nums, int m) {
//        int[][] memo = new int[nums.length][m + 1];
//        memo[0][1] = nums[0];
//        for (int i = 1; i < memo.length; i++) {
//            memo[i][0] = Integer.MAX_VALUE;
//            memo[i][1] = memo[i - 1][1] + nums[i];
//        }
//        return helper(nums, nums.length - 1, m, memo);
//    }
//
//    private int helper(int[] nums, int start, int m, int[][] memo) {
//        if (memo[start][m] > 0) {
//            return memo[start][m];
//        }
//        int min = Integer.MAX_VALUE;
//        int sum = 0;
//        for (int i = start; i >= 1; i--) {
//            sum += nums[i];
//            min = Math.min(Math.max(sum, helper(nums, i - 1, m - 1, memo)), min);
//        }
//        memo[start][m] = min;
//        return memo[start][m];
//    }
}
