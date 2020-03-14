package com.example.ignore.amazon;

public class TrappingRainWater {
    //Two pointers
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;

        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        int totalWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else totalWater += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else totalWater += rightMax - height[right];
                right--;
            }
        }
        return totalWater;
    }

//    DP
//    public int trap(int[] height) {
//        int n = height.length;
//        if (n < 3) return 0;
//
//        int[] leftMax = new int[n];
//        leftMax[0] = height[0];
//        for (int i = 1; i < n; i++) {
//            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//        }
//
//        int[] rightMax = new int[n];
//        rightMax[n - 1] = height[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//        }
//
//        int totalWater = 0;
//        for (int i = 0; i < n; i++) {
//            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
//        }
//        return totalWater;
//    }

    /**
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     *        _
     *    _    _ _
     *  _  _ _  _ _
     * _ _  _
     */
}
