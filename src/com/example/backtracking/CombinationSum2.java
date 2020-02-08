package com.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] test = {10,1,2,7,6,1,5};
        List<List<Integer>> result = new CombinationSum2().combinationSum2(test, 8);
        result.forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i == index || candidates[i] != candidates[i - 1]) {
                    current.add(candidates[i]);
                    findCombinations(candidates, i + 1, target - candidates[i], current, result);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
