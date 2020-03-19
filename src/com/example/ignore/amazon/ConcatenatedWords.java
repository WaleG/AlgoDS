package com.example.ignore.amazon;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    /*
     * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
     *
     * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
     *
     * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
     *  "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
     * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
     */

    public static void main(String[] args) {
        String[] input = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        List<String> output = new ConcatenatedWords().findAllConcatenatedWordsInADict(input);
        System.out.println(output);
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        for (String word : words) {
            if (isConcatenation(0, word, 0, trie.root)) result.add(word);
        }
        return result;
    }

    private boolean isConcatenation(int index, String word, int count, TrieNode root) {
        TrieNode curr = root;

        for (int i = index; i < word.length(); i++) {
            curr = curr.children[word.charAt(i) - 'a'];
            if (curr == null) return false;
            if (curr.isWord) {
                if (i == word.length() - 1) return count >= 1;
                if (isConcatenation(i + 1, word, count + 1, root)) return true;
            }
        }

        return false;
    }

    public static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) curr.children[index] = new TrieNode();
                curr = curr.children[index];
            }

            curr.isWord = true;
        }
    }

//    public List<String> findAllConcatenatedWordsInADict(String[] words) {
//        List<String> result = new ArrayList<>();
//        Set<String> dict = new HashSet<>(Arrays.asList(words));
//        for (String word : words) {
//            dfs(word, 0, 0, 0, dict, result);
//        }
//        return result;
//    }
//
//    private void dfs(String word, int start, int end, int wordsCount, Set<String> dict, List<String> result) {
//        if (start == word.length()) {
//            if (wordsCount >= 2) result.add(word);
//        } else {
//            for (int i = end; i <= word.length(); i++) {
//                if (dict.contains(word.substring(start, i))) {
//                    dfs(word, i, i, wordsCount + 1, dict, result);
//                }
//            }
//        }
//    }
}
