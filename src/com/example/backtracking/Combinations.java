package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void combine(int n, int k, int index, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
        } else if (current.size() < k) {
            for (int i = index; i <= n; i++) {
                current.add(i);
                combine(n, k, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
