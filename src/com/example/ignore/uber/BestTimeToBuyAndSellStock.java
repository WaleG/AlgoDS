package com.example.ignore.uber;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price: prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(price - minPrice, maxProfit);
        }
        return maxProfit;
    }
}
