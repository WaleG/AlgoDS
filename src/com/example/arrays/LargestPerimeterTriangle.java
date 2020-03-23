package com.example.arrays;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] <= A[i - 1] + A[i - 2]) return A[i - 1] + A[i - 2] + A[i];
        }
        return 0;
    }
}