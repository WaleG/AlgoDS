package com.example.ignore.amazon;

import java.util.*;

public class PrintPhrasesInStreamOfWords {
    public static void main(String[] args) {
        List<String> phrases = Arrays.asList("a cat", "through the grass", "i saw a cat running");
        List<String> stream = Arrays.asList(
                (
                        "i was walking through the park and saw a cat running " +
                                "through the grass then i saw a cat running from the bushes"
                ).split(" ")
        );
        List<String> result = new PrintPhrasesInStreamOfWords().printPhases(phrases, stream);
        System.out.println(result);
    }

    private TrieNode root;
    private List<String> words;

    public PrintPhrasesInStreamOfWords() {
        this.root = new TrieNode();
        words = new ArrayList<>();
    }

    public List<String> printPhases(List<String> phrases, List<String> stream) {
        List<String> result = new ArrayList<>();
        for (String phrase : phrases) {
            this.add(phrase);
        }
        for (String word : stream) {
            words.add(word);
            TrieNode curr = root;
            for (int i = words.size() - 1; i >= 0 && curr != null; i--) {
                String currWord = words.get(i);
                curr = curr.children.get(currWord);
                if (curr != null && curr.isPhrase) result.add(curr.fullPhrase);
            }
        }
        return result;
    }


    private void add(String phrase) {
        String[] words = phrase.split(" ");
        TrieNode curr = root;
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            curr = curr.children.computeIfAbsent(word, k -> new TrieNode());
        }
        curr.isPhrase = true;
        curr.fullPhrase = phrase;
    }

    private static class TrieNode {
        boolean isPhrase;
        String fullPhrase;
        Map<String, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }
    }
}
