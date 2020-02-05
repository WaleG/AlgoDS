package com.example.dynamicprogramming;

import java.util.Arrays;

public class FibonacciNumbers {
    //bottom-up DP
    public int fib(int n) {
        int[] cache = new int[n+1];

        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i < cache.length; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }

//    //recursive
//    public int fib(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return fib(n - 1) + fib(n - 2);
//    }

//    //top-down DP
//    public int fib(int n) {
//        int[] cache = new int[n+1];
//
//        Arrays.fill(cache, -1);
//
//        cache[0] = 0;
//        cache[1] = 1;
//
//        return fib(n, cache);
//    }
//
//    private int fib(int n, int[] cache) {
//        if (cache[n] != -1) return cache[n];
//        cache[n] = fib(n - 1, cache) + fib(n - 2, cache);
//        return cache[n];
//    }
}
