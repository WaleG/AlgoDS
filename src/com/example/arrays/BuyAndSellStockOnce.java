package com.example.arrays;

import java.util.List;

public class BuyAndSellStockOnce {

    public static double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for (double price: prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}
