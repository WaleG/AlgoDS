package com.example.arrays;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] test = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int result = new MaxConsecutiveOnesIII().longestOnes(test, 2);
        System.out.println(result);
    }

    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int count = 0;
        int maxLength = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (A[end] == 0) count++;
            while (count > K) {
                if (A[start++] == 0) count--;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
