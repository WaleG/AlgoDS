package com.example.dynamicprogramming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int preprev = 1, prev = 1, cur  = 1;
        while (n-- >= 2) {
            cur = preprev + prev;
            preprev = prev;
            prev = cur;
        }
        return cur;
    }
}

