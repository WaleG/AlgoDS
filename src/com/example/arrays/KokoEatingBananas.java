package com.example.arrays;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = getMaxPile(piles);

        while (lo <= hi) {
            int K = (lo + hi) / 2;
            if (possible(piles, H, K)) {
                hi = K - 1;
            } else {
                lo = K + 1;
            }
        }

        return lo;
    }

    private boolean possible(int[] piles, int H, int K) {
        int hours = 0;
        for (int pile: piles) {
            hours += pile / K;
            if (pile % K != 0) {
                hours++;
            }
        }
        return hours <= H;
    }

    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        return maxPile;
    }
}
