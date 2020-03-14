package com.example.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    //dfs
    public boolean wordBreak(String s, List<String> wordDict) {
        // DFS
        Set<String> dict = new HashSet<>(wordDict);
        Set<Integer> path = new HashSet<>();
        return dfs(s, 0, dict, path);
    }

    private boolean dfs(String s, int from, Set<String> dict, Set<Integer> path) {
        // base case
        if (from == s.length()) {
            return true;
        }
        // check memory
        if (path.contains(from)) {
            return false;
        }
        // recursion
        for (int i = from + 1; i <= s.length(); i++) {
            String t = s.substring(from, i);
            if (dict.contains(t) && dfs(s, i, dict, path)) {
                return true;
            }
        }
        path.add(from);
        return false;
    }

//    //DP top-down
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> dict = new HashSet<>(wordDict);
//        Boolean[] canBreak = new Boolean[s.length() + 1];
//        return wordBreak(s, 0, dict, canBreak);
//    }
//
//    private boolean wordBreak(String s , int from, Set<String> dict, Boolean[] canBreak) {
//        if (from == s.length()) return true;
//        if (canBreak[from] != null) return canBreak[from];
//        boolean result = false;
//        for (int i = from + 1; i <= s.length(); i++) {
//            String candidate = s.substring(from, i);
//            if (dict.contains(candidate) && wordBreak(s, i, dict, canBreak)) {
//                result = true;
//                break;
//            }
//        }
//        canBreak[from] = result;
//        return result;
//    }

//    //recursive
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> dict = new HashSet<>(wordDict);
//        return wordBreak(s, 0, dict);
//    }
//
//    private boolean wordBreak(String s , int from, Set<String> dict) {
//        if (from == s.length()) return true;
//        for (int i = from; i <= s.length(); i++) {
//            String candidate = s.substring(from, i);
//            if (dict.contains(candidate)) {
//                boolean isBreak = wordBreak(s, i, dict);
//                if (isBreak) return true;
//            }
//        }
//        return false;
//    }
}
