package com.example.arrays;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 1) return true;
        boolean nonDecreasing = true;
        boolean nonIncreasing = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                nonIncreasing = false;
            } else if (A[i] < A[i - 1]) {
                nonDecreasing = false;
            }
            if (!nonIncreasing && !nonDecreasing) return false;
        }
        return true;
    }
}
