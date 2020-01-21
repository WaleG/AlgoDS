package com.example.arrays;

import java.util.Arrays;

public class BuyAndSellStockKTimes {
    public static int buyAndSellStockKTimes(int k, int[] prices) {
        if (k == 0 || prices.length <= 1) return 0;
        int[] buyK = new int[k];
        int[] buySellK = new int[k];

        Arrays.fill(buyK, Integer.MAX_VALUE);
        Arrays.fill(buySellK, 0);

        for (int price : prices) {
            for (int i = 1; i < buySellK.length; i++) {
                buySellK[i] = Math.max(buySellK[i], price - buyK[i]);
                buyK[i] = Math.min(buyK[i], price - buySellK[i - 1]);
            }
            buySellK[0] = Math.max(buySellK[0], price - buyK[0]);
            buyK[0] = Math.min(buyK[0], price);
        }

        return buySellK[k - 1];
    }
}
