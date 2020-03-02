package com.example.trees.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    public static void main(String[] args) {
        WordDictionary t = new WordDictionary();
        t.addWord("bad");
        System.out.println(t.search("b.."));
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != '.') {
                TrieNode next = node.children.get(c);
                if (next == null) {
                    return false;
                } else {
                    node = next;
                }
            } else {
                for (TrieNode child: node.children.values()) {
                    if (search(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return node.isWord;
    }

    private static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }
    }
}
