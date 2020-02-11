package com.example.arrays;

import java.util.Arrays;

public class ColorSort {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] failed = {2, 0, 1};
        new ColorSort().sortColors(failed);
        System.out.println(Arrays.toString(failed));
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int pivot = 1;
        int lt = 0;
        int gt = n - 1;
        int i = 0;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i++, lt++);
            } else if (nums[i] == pivot) {
                i++;
            } else {
                swap(nums, gt--, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
