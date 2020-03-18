package com.example.ignore.amazon;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 10;
        int c = new CountPrimes().countPrimes(n);
        System.out.println(c);
    }

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    private boolean isPrime(int i) {
        if (i <= 1) return false;
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
