package com.example.dynamicprogramming;

import java.util.Arrays;

public class MakingCoinChange {

    private int[] coins = new int[]{10, 6, 1};

    //bottom-up DP
    // Bottom up dynamic programming solution.
    // Iteratively compute number of coins for
    // larger and larger amounts of change
    public int makeChange(int c, int[] coins) {
        int[] cache = new int[c + 1];
        cache[0] = 0;
        for (int i = 1; i < cache.length; i++) {
            int minCoins = Integer.MAX_VALUE;
            // Try removing each coin from the total
            // and see which requires the fewest
            // extra coins
            for (int coin: coins) {
                if (i - coin >= 0) {
                    int currCoins = cache[i - coin] + 1;
                    if (currCoins < minCoins) {
                        minCoins = currCoins;
                    }
                }
            }
            cache[i] = minCoins;
        }
        return cache[c];
    }

//    //top-down DP
//    public int makeChange(int c, int[] coins) {
//        int[] cache = new int[c + 1];
//        Arrays.fill(cache, -1);
//        cache[0] = 0;
//        return makeChange(c, coins, cache);
//    }
//
//    private int makeChange(int c, int[] coins, int[] cache) {
//        if (cache[c] != -1) return cache[c];
//        int minCoins = Integer.MAX_VALUE;
//        // Try removing each coin from the total and
//        // see how many more coins are required
//        for (int coin: coins) {
//            // Skip a coin if it’s value is greater
//            // than the amount remaining
//            if (c - coin >= 0) {
//                int currMinCoins = makeChange(c - coin, coins);
//                if (currMinCoins < minCoins) {
//                    minCoins = currMinCoins;
//                }
//            }
//        }
//        cache[c] = minCoins + 1;
//        return cache[c];
//    }

//    //recursive
//    public int makeChange(int c, int[] coins) {
//        if (c == 0) return 0;
//        int minCoins = Integer.MAX_VALUE;
//        // Try removing each coin from the total and
//        // see how many more coins are required
//        for (int coin: coins) {
//            // Skip a coin if it’s value is greater
//            // than the amount remaining
//            if (c - coin >= 0) {
//                int currMinCoins = makeChange(c - coin, coins);
//                if (currMinCoins < minCoins) {
//                    minCoins = currMinCoins;
//                }
//            }
//        }
//        return minCoins + 1;
//    }
}
