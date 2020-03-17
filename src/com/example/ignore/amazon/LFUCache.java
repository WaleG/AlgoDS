package com.example.ignore.amazon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    private Map<Integer, Integer> items;
    private Map<Integer, Integer> frequencies;
    private Map<Integer, LinkedHashSet<Integer>> freqToItemMap;
    int capacity;
    int least;


    public LFUCache(int capacity) {
        items = new HashMap<>();
        frequencies = new HashMap<>();
        freqToItemMap = new HashMap<>();
        this.capacity = capacity;
        freqToItemMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!items.containsKey(key)) return -1;

        int freq = frequencies.get(key);
        frequencies.put(key, freq + 1);

        freqToItemMap.get(freq).remove(key);

        if (freq == least && freqToItemMap.get(freq).size() == 0) least++;

        freqToItemMap.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToItemMap.get(freq + 1).add(key);

        return items.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (items.containsKey(key)) {
            items.put(key, value);
            get(key);
            return;
        }

        if (items.size() == capacity) {
            removeLFU();
        }

        items.put(key, value);
        frequencies.put(key, 1);
        least = 1;
        freqToItemMap.get(1).add(key);
    }

    private void removeLFU() {
        Iterator<Integer> it = freqToItemMap.get(least).iterator();
        int evict = it.next();
        it.remove();
        items.remove(evict);
        frequencies.remove(evict);
    }
}
