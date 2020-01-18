package com.example.arrays;

import java.util.Arrays;
import java.util.List;

public class AdvancingThroughAnArray {
    public static void main(String[] args) {
        List<Integer> valid = Arrays.asList(2, 4, 1, 1, 0, 2, 3);
        boolean t = canReachEnd(valid);
        System.out.println(t);
        List<Integer> invalid = Arrays.asList(3, 2, 0, 0, 2, 0, 1);
        boolean f = canReachEnd(invalid);
        System.out.println(f);
    }

    public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
        if (maxAdvanceSteps == null || maxAdvanceSteps.isEmpty()) return false;
        int maxCanAdvance = 0;
        for (int i = 0; i < maxAdvanceSteps.size(); i++) {
            if (maxCanAdvance < i) return false;
            maxCanAdvance = Math.max(maxCanAdvance, i + maxAdvanceSteps.get(i));
        }
        return true;
    }
}
