package com.example.ignore.facebook;

import java.util.Random;

public class RandomPickIndex {
    private int[] nums;
    private Random rnd;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rnd.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }
}
