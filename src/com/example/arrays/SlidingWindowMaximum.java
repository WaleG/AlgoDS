package com.example.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
//        Output: [3,3,5,5,6,7]
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return nums;
        int[] max = new int[n - k + 1];

        LinkedList<Integer> dll = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!dll.isEmpty() && dll.getFirst() < i - k + 1) {
                dll.removeFirst();
            }

            while (!dll.isEmpty() && nums[dll.getLast()] <= nums[i]) {
                dll.removeLast();
            }

            dll.addLast(i);

            if (i - k + 1 >= 0) {
                max[i - k + 1] = nums[dll.getFirst()];
            }
        }

        return max;
    }
}
