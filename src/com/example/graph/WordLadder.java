package com.example.graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        int result = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> notVisited = new HashSet<>(wordList);
        q.add(beginWord);
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            for (int size = q.size(); size > 0; size--) {
                String word = q.remove();
                if (word.equals(endWord)) {
                    return count;
                }
                Iterator<String> it = notVisited.iterator();
                while (it.hasNext()) {
                    String candidate = it.next();
                    if (isTransformation(word, candidate)) {
                        q.add(candidate);
                        it.remove();
                    }
                }
            }

        }
        return 0;
    }

    private boolean isTransformation(String word, String candidate) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != candidate.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}
