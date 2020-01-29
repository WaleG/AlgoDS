package com.example.arrays;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while (lo < hi) {
            max = Math.max(max, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return max;
    }
}
