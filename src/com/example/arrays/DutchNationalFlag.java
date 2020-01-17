package com.example.arrays;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] a = {1, 5, 50, 30, 45, 3, 7, 45, 76, 9};
        dutchFlagPartition(a);
        System.out.println(Arrays.toString(a));
    }

    public static void dutchFlagPartition(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static void quicksort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pivot = threeWayPartition(a, lo, hi);
            quicksort(a, lo, pivot - 1);
            quicksort(a, pivot + 1, hi);
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j] < pivot) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, hi);
        return i + 1;
    }

    private static int threeWayPartition(int[] a, int lo, int hi) {
        int lt = lo, gt = hi;
        int pivot = a[lo];
        int i = lo;
        while (i <= gt) {
            if (a[i] < pivot) {
                swap(a, lt++, i++);
            } else if (a[i] > pivot) {
                swap(a, gt--, i);
            } else {
                i++;
            }
        }
        return gt;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
