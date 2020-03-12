package com.example.ignore.amazon;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> c = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (c.containsKey(comp)) {
                return new int[]{c.get(comp), i};
            } else {
                c.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
