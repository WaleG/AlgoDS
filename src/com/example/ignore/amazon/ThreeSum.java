package com.example.ignore.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1;
            int hi = nums.length - 1;
            int comp = - nums[i];
            while (lo < hi) {
                if (comp == nums[lo] + nums[hi]) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (comp > nums[lo] + nums[hi]) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }
}
