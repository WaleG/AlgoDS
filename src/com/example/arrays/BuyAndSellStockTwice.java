package com.example.arrays;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellStockTwice {

//    O(n) time and O(n) space
//    public static double buyAndSellStockTwice(List<Double> prices) {
//        List<Double> firstBuySell = new ArrayList<>();
//        double maxTotalProfit = 0.0;
//        double minPriceSoFar = Double.MAX_VALUE;
//        for (int i = 0; i < prices.size(); i++) {
//            maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - minPriceSoFar);
//            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
//            firstBuySell.set(i, maxTotalProfit);
//        }
//
//        double maxPriceSoFar = Double.MIN_VALUE;
//        for (int i = prices.size() - 1; i >= 0; i--) {
//            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
//            maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar - prices.get(i) + firstBuySell.get(i));
//        }
//        return maxTotalProfit;
//    }

    // O(n) time O(1) space
    public static double buyAndSellStockTwice(List<Double> prices) {
        double oneBuy = Double.MAX_VALUE;
        double oneBuyOneSell = 0.0;
        double twoBuy = Double.MAX_VALUE;
        double twoBuyTwoSell = 0.0;
        for (double price: prices) {
            twoBuyTwoSell = Math.max(twoBuyTwoSell, price - twoBuy);
            twoBuy = Math.min(twoBuy, price - oneBuyOneSell);
            oneBuyOneSell = Math.max(oneBuyOneSell, price - oneBuy);
            oneBuy = Math.min(oneBuy, price);
        }
        return twoBuyTwoSell;
    }
}
