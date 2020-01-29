package com.example.arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prod = 1;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            result = Math.max(result, prod);
            if (prod == 0) {
                prod = 1;
            }
        }

        prod = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            result = Math.max(result, prod);
            prod = Math.max(prod, 0);
        }

        return result;
    }
}
