package com.example.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num: nums) {
            if (unique.contains(num)) {
                return true;
            } else {
                unique.add(num);
            }
        }
        return false;
    }
}
