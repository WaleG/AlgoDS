package com.example.arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] one = new int[]{1};
        int result = new SearchInRotatedSortedArray().search(one, 1);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            double candidate = (nums[mid] < nums[0]) == (target < nums[0]) ?
                    nums[mid] : target < nums[mid] ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            if (candidate < target)
                lo = mid + 1;
            else if (candidate > target)
                hi = mid;
            else
                return mid;
        }
        return -1;
    }
}
