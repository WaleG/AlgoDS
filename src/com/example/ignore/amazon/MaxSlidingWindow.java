package com.example.ignore.amazon;

import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] max = new int[n - k + 1];
        LinkedList<Integer> candIdicies = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int maxIdx = i - k + 1;

            if (!candIdicies.isEmpty() && candIdicies.getFirst() < maxIdx) {
                candIdicies.pollFirst(); //remove indexes out of k range
            }

            while (!candIdicies.isEmpty() && nums[candIdicies.getLast()] < nums[i]) {
                candIdicies.removeLast(); //remove candidates less than current num
            }

            candIdicies.addLast(i); // add current index as candidate

            if (maxIdx >= 0) {
                max[maxIdx] = nums[candIdicies.getFirst()]; // add the best candidate to the result array
            }
        }

        return max;
    }

    /**
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     */
}
