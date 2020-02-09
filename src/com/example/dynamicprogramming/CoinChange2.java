package com.example.dynamicprogramming;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int row = 0; row < dp.length; row++) {
            dp[row][0] = 1;
        }
        for (int row = 1; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                dp[row][col] = dp[row - 1][col];
                int prevColIndex = col - coins[row - 1];
                if (prevColIndex >= 0) {
                    dp[row][col] += dp[row][prevColIndex];
                }
            }
        }
        return dp[coins.length][amount];
    }
////    recursive
//    public int change(int amount, int[] coins) {
//        return change(amount, coins, 0);
//    }
//
//    private int change(int amount, int[] coins, int index) {
//        if (amount == 0) {
//            return 1;
//        } else if (amount < 0) {
//            return 0;
//        } else {
//            int ways = 0;
//            for (int i = index; i < coins.length; i++) {
//                ways += change(amount - coins[i], coins, i);
//            }
//            return ways;
//        }
//    }
}
