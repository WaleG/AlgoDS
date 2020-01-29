package com.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
Given array nums = [-1, 0, 1, 2, -1, -4],
sorted = [-4, -1, -1, 0, 1, 2]
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int comp = -nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == comp) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                } else if (nums[lo] + nums[hi] < comp) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result;
    }
}
