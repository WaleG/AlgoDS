package com.example.ignore.amazon;

import java.util.*;

public class WordLadder2 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        List<List<String>> result = new WordLadder2().findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, Set<String>> g = buildGraph(wordList);

        Queue<ListNode> q = new LinkedList<>();
        q.add(new ListNode(beginWord, null));

        Set<String> seen = new HashSet<>();
        List<List<String>> result = new LinkedList<>();

        boolean isLastLevel = false;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                ListNode currentNode = q.remove();

                if (currentNode.word.equals(endWord)) {
                    result.add(restorePath(currentNode));
                    isLastLevel = true;
                }

                seen.add(currentNode.word);

                Set<String> neighbours = g.get(currentNode.word);
                if (neighbours != null) {
                    for (String neighbour : neighbours) {
                        if (!seen.contains(neighbour)) q.add(new ListNode(neighbour, currentNode));
                    }
                }
            }

            if (isLastLevel) break;
        }
        return result;
    }

    private Map<String, Set<String>> buildGraph(List<String> wordList) {
        Map<String, Set<String>> g = new HashMap<>();
        int n = wordList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = wordList.get(i);
                String s2 = wordList.get(j);
                if (isTransformation(s1, s2)) {
                    Set<String> n1 = g.getOrDefault(s1, new HashSet<>());
                    Set<String> n2 = g.getOrDefault(s2, new HashSet<>());
                    n1.add(s2);
                    n2.add(s1);
                    g.put(s1, n1);
                    g.put(s2, n2);
                }
            }
        }
        return g;
    }

    private boolean isTransformation(String from, String to) {
        int diff = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

    private List<String> restorePath(ListNode last) {
        if (last == null) return new LinkedList<>();
        List<String> path = restorePath(last.prev);
        path.add(last.word);
        return path;
    }

    private static class ListNode {
        String word;
        ListNode prev;

        public ListNode(String word, ListNode prev) {
            this.word = word;
            this.prev = prev;
        }
    }
}
