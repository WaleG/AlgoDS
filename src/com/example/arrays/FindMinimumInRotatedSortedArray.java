package com.example.arrays;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums.length == 1 || nums[hi] > nums[0]) {
            return nums[0];
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[0]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
