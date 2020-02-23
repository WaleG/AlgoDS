package com.example.arrays;

public class MaximumSwap {
    public static void main(String[] args) {
        int test = 1993;
        int res = new MaximumSwap().maximumSwap(test);
        System.out.println(res);
    }

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        if (digits.length <= 1) return num;
        int firstGreater = 1;
        while (firstGreater < digits.length && digits[firstGreater - 1] >= digits[firstGreater]) {
            firstGreater++;
        }
        if (firstGreater == digits.length) return num;

        char max = '0';
        int maxIndex = firstGreater;
        for (int i = firstGreater; i < digits.length; i++) {
            if (digits[i] >= max) {
                max = digits[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < firstGreater; i++) {
            if (max > digits[i]) {
                digits[maxIndex] = digits[i];
                digits[i] = max;
                break;
            }
        }

        return Integer.parseInt(new String(digits));
    }
}
