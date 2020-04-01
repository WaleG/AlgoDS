package com.example.arrays;

public class RemoveDuplicatesFromASortedArray2 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int r = new RemoveDuplicatesFromASortedArray2().removeDuplicates(nums);
        System.out.println(r);
    }

    public int removeDuplicates(int[] nums) {
        int insert = 0;
        for (int num : nums) {
            if (insert < 2 || num > nums[insert - 2]) {
                nums[insert++] = num;
            }
        }
        return insert;
    }

    /*
     * Given nums = [0,0,1,1,1,1,2,3,3],
     *
     * Your function should return length = 7,
     * with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
     *
     * It doesn't matter what values are set beyond the returned length.
     */
}
