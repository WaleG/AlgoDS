package com.example.strings;

import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        int n = S.length();
        int[] counts = new int[26];

        for (char c : S.toCharArray()) {
            counts[c - 'a']++;
        }

        PriorityQueue<Char> pq = new PriorityQueue<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > (n + 1) / 2) return "";
            if (counts[i] > 0) {
                pq.add(new Char((char) ('a' + i), counts[i]));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            Char first = pq.remove();
            Char second = pq.remove();

            sb.append(first.letter);
            sb.append(second.letter);

            if (--first.count > 0) {
                pq.add(first);
            }
            if (--second.count > 0) {
                pq.add(second);
            }
        }

        if (!pq.isEmpty()) {
            sb.append(pq.remove().letter);
        }

        return sb.toString();
    }

    private static class Char implements Comparable<Char> {
        char letter;
        int count;

        public Char(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public int compareTo(Char that) {
            if (this.count == that.count) {
                return this.letter - that.letter;
            } else {
                return that.count - this.count;
            }
        }
    }
}
