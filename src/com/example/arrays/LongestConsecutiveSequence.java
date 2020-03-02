package com.example.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int num: nums) {
            s.add(num);
        }

        int longestStreak = 0;

        for (int num: s) {
            if (!s.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;

                while (s.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }

                longestStreak = Math.max(longestStreak, currStreak);
                if (longestStreak > nums.length / 2) return longestStreak;
            }

        }

        return longestStreak;
    }
}
