package com.example.ignore.uber;

public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int buy1 = Integer.MAX_VALUE;
        int buy1Sell1 = 0;

        int buy2 = Integer.MAX_VALUE;
        int buy2Sell2 = 0;

        //construct from bottom to top
        for (int price : prices) {
            buy2Sell2 = Math.max(buy2Sell2, price - buy2);
            buy2 = Math.min(buy2, price - buy1Sell1);
            buy1Sell1 = Math.max(buy1Sell1, price - buy1);
            buy1 = Math.min(price, buy1);
        }

        return buy2Sell2;
    }
}
