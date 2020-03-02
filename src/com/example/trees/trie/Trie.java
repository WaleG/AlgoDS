package com.example.trees.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("word");
        boolean isWord = t.search("word");
        boolean isNotWord = t.search("wod");
        System.out.println(isWord);
        System.out.println(isNotWord);
        t.insert("wod");
        System.out.println(t.search("wod"));
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode next = node.children.get(c);
            if (next == null) {
                return false;
            } else {
                node = next;
            }
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode next = node.children.get(c);
            if (next == null) {
                return false;
            } else {
                node = next;
            }
        }
        return true;
    }

    private static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }
    }
}
