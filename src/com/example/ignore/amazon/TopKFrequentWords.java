package com.example.ignore.amazon;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] s1 = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> r1 = new TopKFrequentWords().topKFrequent(s1, 2);
        System.out.println(r1);
        String[] s2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> r2 = new TopKFrequentWords().topKFrequent(s2, 4);
        System.out.println(r2);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            int f = freq.getOrDefault(word, 0);
            freq.put(word, f + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
                (w1, w2) -> freq.get(w1).equals(freq.get(w2)) ?
                        w2.compareTo(w1) : freq.get(w1) - freq.get(w2));

        for (String word : freq.keySet()) {
            pq.add(word);
            if (pq.size() > k) pq.remove();
        }

        int size = pq.size();
        String[] result = new String[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return Arrays.asList(result);
    }
}
