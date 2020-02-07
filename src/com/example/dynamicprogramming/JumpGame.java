package com.example.dynamicprogramming;

public class JumpGame {
    public static void main(String[] args) {
        int[] a = {1, 2 ,3};
        boolean canJump = new JumpGame().canJump(a);
        System.out.println(canJump);
    }

    //greedy
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachable < i) {
                return false;
            }
            reachable = Math.max(i + nums[i], reachable);
        }
        return true;
    }

//    //bottom-up DP
//    public boolean canJump(int[] nums) {
//        if (nums.length <= 1) return true;
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int lastReached = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (dp[i] == 0) return false;
//            int maxJump = i + nums[i];
//            if (maxJump >= nums.length - 1) return true;
//            if (maxJump > lastReached) {
//                for (int j = lastReached + 1; j <= maxJump; j++) {
//                    dp[j] = 1;
//                }
//            }
//        }
//        return true;
//    }
}
