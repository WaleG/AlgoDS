package com.example.primitives;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int countZeroes = 0;
            int countOnes = 0;
            for (int num: nums) {
                if ((num & mask) != 0) {
                    countOnes++;
                } else {
                    countZeroes++;
                }
            }
            total += countOnes * countZeroes;
        }
        return total;
    }
}
