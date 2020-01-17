package com.example.arrays;

public class EvenOdd {
    public static void evenOdd(int[] arr) {
        int even = 0, odd = arr.length - 1;
        while (even < odd) {
            if (arr[even] % 2 == 0) {
                even++;
            } else {
                swap(arr, even, odd);
                odd--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
