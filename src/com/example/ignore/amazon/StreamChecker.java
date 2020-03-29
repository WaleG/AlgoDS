package com.example.ignore.amazon;

import java.util.HashMap;
import java.util.Map;

public class StreamChecker {
    public static void main(String[] args) {
        //["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query","query"]
        //[[["abaa","abaab","aabbb","bab","ab"]],["a"],["a"],["b"],["b"],["b"],["a"],["a"],["b"],["b"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["b"],["b"],["b"],["a"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["a"],["b"],["b"],["b"],["a"],["b"],["a"]]
        String[] arr = {"abaa", "abaab", "aabbb", "bab", "ab"};
        StreamChecker streamChecker = new StreamChecker(arr); // init the dictionary.
        boolean res;
        res = streamChecker.query('a');
        System.out.println(res);         // return false
        res = streamChecker.query('a');
        System.out.println(res);         // return false
        res = streamChecker.query('b');
        System.out.println(res);         // return false
        res = streamChecker.query('b');
        System.out.println(res);         // return true, because 'cd' is in the wordlist
        res = streamChecker.query('b');
        System.out.println(res);         // return false
        res = streamChecker.query('f');
        System.out.println(res);         // return true, because 'f' is in the wordlist
        res = streamChecker.query('g');
        System.out.println(res);         // return false
        res = streamChecker.query('h');
        System.out.println(res);         // return false
        res = streamChecker.query('i');
        System.out.println(res);         // return false
        res = streamChecker.query('j');
        System.out.println(res);         // return false
        res = streamChecker.query('k');
        System.out.println(res);         // return false
        res = streamChecker.query('l');
        System.out.println(res);         // return true, because 'kl' is in the wordlist
    }

    private TrieNode root;
    private StringBuilder sb;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for (String word : words) {
            addWord(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;

        for (int i = sb.length() - 1; i >= 0 && curr != null; i--) {
            char c = sb.charAt(i);
            curr = curr.children.get(c);
            if (curr != null && curr.isWord) return true;
        }
        return false;
    }

    private void addWord(String word) {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            curr = curr.children.computeIfAbsent(c, k -> new TrieNode());
        }
        curr.isWord = true;
    }

    private static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }
}


