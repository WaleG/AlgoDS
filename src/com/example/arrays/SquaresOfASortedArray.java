package com.example.arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int j = 0;

        while (j < n && A[j] < 0) {
            j++;
        }
        int i = j - 1;

        int[] result = new int[n];
        int k = 0;

        while (i >= 0 && j < n) {
            int negative = A[i] * A[i];
            int positive = A[j] * A[j];
            if (negative > positive) {
                result[k++] = positive;
                j++;
            } else {
                result[k++] = negative;
                i--;
            }
        }

        while (i >= 0) {
            result[k++] = A[i] * A[i];
            i--;
        }

        while (j < n) {
            result[k++] = A[j] * A[j];
            j++;
        }

        return result;
    }
}
