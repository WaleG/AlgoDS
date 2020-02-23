package com.example.graph;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, Set<Character>> g = new HashMap<>();
        buildGraph(g, words, indegree);
        return dfs(g, indegree);
    }

    private String dfs(Map<Character, Set<Character>> g, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        int totalLen = g.size();
        Queue<Character> q = new PriorityQueue<>();

        for (char c : g.keySet()) {
            if (indegree[c - 'a'] == 0) {
                q.add(c);
            }
        }

        while (!q.isEmpty()) {
            char curr = q.remove();
            sb.append(curr);
            for (char c : g.get(curr)) {
                indegree[c - 'a']--;
                if (indegree[c - 'a'] == 0) {
                    q.add(c);
                }
            }
        }

        return totalLen == sb.length() ? sb.toString() : "";
    }

    private void buildGraph(Map<Character, Set<Character>> g, String[] words, int[] indegree) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                g.putIfAbsent(word.charAt(i), new TreeSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];

            int len = Math.min(first.length(), second.length());

            for (int j = 0; j < len; j++) {
                char out = first.charAt(j);
                char in = second.charAt(j);

                if (out != in) {
                    if (!g.get(out).contains(in)) {
                        indegree[in - 'a']++;
                        g.get(out).add(in);
                    }

                    break;
                }
            }
        }
    }
}
