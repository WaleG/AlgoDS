package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combine(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void combine(int k, int n, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k && n == 0) {
            result.add(new ArrayList<>(current));
        }
        if (current.size() < k && n > 0) {
            for (int i = start; i <= 9; i++) {
                current.add(i);
                combine(k, n - i, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
