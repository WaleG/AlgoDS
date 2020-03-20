package com.example.dynamicprogramming;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 13;
        int numS = new PerfectSquares().numSquares(n);
        System.out.println(numS);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = n;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int diff = i - j * j;
                dp[i] = Math.min(dp[i], dp[diff] + 1);
            }
        }
        return dp[n];
    }

//    public int numSquares(int n) {
//        return numSquares(n, (int) Math.ceil(Math.sqrt(n)),0, 0);
//    }
//
//    private int numSquares(int n, int curr, int sumSoFar, int count) {
//        if (curr == 0) return n;
//        if (sumSoFar > n) return n;
//        else if (sumSoFar == n) return count;
//        int min = n;
//        for (int i = curr; i >= 1; i--) {
//            int takeThis = numSquares(n, i, i * i + sumSoFar, count + 1);
//            int dontTake = numSquares(n, i - 1, sumSoFar, count);
//            min = Math.min(min, Math.min(takeThis, dontTake));
//        }
//        return min;
//    }
}
