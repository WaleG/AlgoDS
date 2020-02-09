package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<List<Integer>> result = new Permutations().permute(array);
        result.forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), result);
        return result;
    }

    private void permute(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else if (current.size() < nums.length) {
            for (int num : nums) {
                if (!current.contains(num)) {
                    current.add(num);
                    permute(nums, current, result);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
