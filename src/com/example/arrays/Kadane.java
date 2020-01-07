package com.example.arrays;

public class Kadane {

    public static void main(String... args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum continuous sum is " +
                maxSubArraySum(a));
    }

    public static int maxSubArraySum(int[] array) {
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int a : array) {
            maxEndingHere += a;
            if (maxEndingHere < 0) maxEndingHere = 0;
            if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
        }

        return maxSoFar;
    }
}
