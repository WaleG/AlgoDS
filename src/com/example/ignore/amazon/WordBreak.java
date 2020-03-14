package com.example.ignore.amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        boolean r = new WordBreak().wordBreak(s, wordDict);
        System.out.println(r);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] contains = new boolean[s.length() + 1];
        contains[0] = true;
        return canBreak(s, dict, 0, 1, contains);
    }

    private boolean canBreak(String s, Set<String> dict, int from, int to, boolean[] contains) {
        if (to == s.length()) return dict.contains(s.substring(from, to));
        String curr = s.substring(from, to);
        if (dict.contains(curr)) {
            if (contains[from]) contains[to] = true;
            if (canBreak(s, dict, to, to + 1, contains)) return true;
        }
        return canBreak(s, dict, from, to + 1, contains);
    }

    /**
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     *
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     *              Note that you are allowed to reuse a dictionary word.
     *
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     */
}
