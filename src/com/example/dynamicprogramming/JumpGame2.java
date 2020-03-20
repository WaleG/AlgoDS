package com.example.dynamicprogramming;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int jumps = new JumpGame2().jump(arr);
        System.out.println(jumps);
    }

    public int jump(int[] nums) {
        int jumps = 0, currEnd = 0, maxEnd = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxEnd = Math.max(maxEnd, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = maxEnd;
            }
        }

        return jumps;
    }


//    recursion
//    public int jump(int[] nums) {
//        return minJumps(nums, 0, 0);
//    }
//
//    private int minJumps(int[] nums, int index, int jumpsSoFar) {
//        if (index >= nums.length -1) return jumpsSoFar;
//        int minJumps = nums.length - 1;
//        for (int i = 1; i <= nums[index]; i++) {
//            minJumps = Math.min(minJumps, minJumps(nums, index + i, jumpsSoFar + 1));
//        }
//        return minJumps;
//    }

    /*
    Input: [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */
}
