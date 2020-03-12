package com.example.ignore.amazon;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            maxProfit = Math.max(price - minSoFar, maxProfit);
            minSoFar = Math.min(price, minSoFar);
        }
        return maxProfit;
    }
}
