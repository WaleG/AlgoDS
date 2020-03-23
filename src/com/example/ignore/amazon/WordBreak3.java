package com.example.ignore.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak3 {
    public static void main(String[] args) {
        String s = "CatMat";
        String[] dictArr = {"Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"};
        int total = new WordBreak3().wordBreak3(s, new HashSet<>(Arrays.asList(dictArr)));
        System.out.println(total);
    }

    public int wordBreak3(String s, Set<String> dict) {
        Set<String> lower = dict.stream().map(String::toLowerCase).collect(Collectors.toSet());
        Map<String, Integer> memo = new HashMap<>();
        return backtrack(s.toLowerCase(), lower, memo);
    }

    private int backtrack(String s, Set<String> dict, Map<String, Integer> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        int total = 0;
        for (String word: dict) {
            if (s.startsWith(word)) {
                if (word.length() == s.length()) total++;
                else total += backtrack(s.substring(word.length()), dict, memo);
            }
        }
        memo.put(s, total);
        return total;
    }

    /*
     * Give a dictionary of words and a sentence with all whitespace removed,
     * return the number of sentences you can form by inserting whitespaces
     * to the sentence so that each word can be found in the dictionary.
     *
     * Example
     * Example1
     *
     * Input:
     * "CatMat"
     * ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
     * Output: 3
     * Explanation:
     * we can form 3 sentences, as follows:
     * "CatMat" = "Cat" + "Mat"
     * "CatMat" = "Ca" + "tM" + "at"
     * "CatMat" = "C" + "at" + "Mat"
     */
}
