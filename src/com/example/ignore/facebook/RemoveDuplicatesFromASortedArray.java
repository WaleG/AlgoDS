package com.example.ignore.facebook;

public class RemoveDuplicatesFromASortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        int insertIdx = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                nums[insertIdx++] = nums[i];
            }
        }
        return insertIdx;
    }
}
