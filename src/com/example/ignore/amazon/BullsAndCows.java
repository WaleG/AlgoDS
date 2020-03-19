package com.example.ignore.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1123", guess = "0111";
        String result = new BullsAndCows().getHint(secret, guess);
        System.out.println(result);
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0', g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            }
            else {
                //if prev part of guess has curr digit in secret
                //then we found a pair that has same digit with different position
                if (count[s] < 0) cows++;
                //if prev part of secret has curr digit in guess
                //then we found a pair that has same digit with different position
                if (count[g] > 0) cows++;
                count[s]++;
                count[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
