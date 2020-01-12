package com.example.heap;

import java.util.*;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Comparator<Integer> c = Comparator.comparingInt(map::get);
        PriorityQueue<Integer> pq = new PriorityQueue<>(c);

        for (int n : map.keySet()) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }

        Integer[] result = new Integer[pq.size()];
        for (int i = pq.size() - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return Arrays.asList(result);
    }
}
