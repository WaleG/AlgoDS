package com.example.heap;

import java.util.*;
import java.util.stream.Collectors;

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

        List<Integer> result = new ArrayList<>(pq.size());
        result.addAll(pq);
        return result;
    }
}
