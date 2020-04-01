package com.example.ignore.facebook;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,0,1,0};
        int res = new ContiguousArray().findMaxLength(arr);
        System.out.println(res);
    }

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            count += nums[i] == 0 ? -1 : 1;

            if (count == 0) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLength;
    }
}
