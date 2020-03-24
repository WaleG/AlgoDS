package com.example.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {
    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

//        randomSet.insert(0);
//        randomSet.insert(1);
//        randomSet.remove(0);
//        randomSet.remove(0);
        randomSet.insert(3);
        randomSet.insert(3);
        randomSet.getRandom();
        randomSet.getRandom();
        randomSet.insert(1);
        randomSet.remove(3);
        randomSet.getRandom();
        randomSet.getRandom();
        randomSet.insert(0);
        randomSet.remove(0);
//        randomSet.insert(2);
//        randomSet.getRandom();
    }

    private Map<Integer, Integer> map;
    private ArrayList<Integer> array;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        array = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        array.add(val);
        map.put(val, array.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int toRemove = map.remove(val);
        int lastIndex = array.size() - 1;
        swap(toRemove, lastIndex);
        array.remove(lastIndex);
        if (toRemove != lastIndex) map.put(array.get(toRemove), toRemove);
        return true;
    }

    private void swap(int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int random = ThreadLocalRandom.current().nextInt(array.size());
        return array.get(random);
    }
}
