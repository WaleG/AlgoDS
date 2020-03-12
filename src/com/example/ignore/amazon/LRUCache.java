package com.example.ignore.amazon;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            removeNodeFromList(node);
            insertToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            map.put(key, node);
            removeNodeFromList(node);
        } else {
            if (map.size() == capacity) {
                deleteLRUNode();
            }
            node = new Node(value);
            node.key = key;
            map.put(key, node);
        }
        insertToHead(node);
    }

    private void deleteLRUNode() {
        Node toRemove = tail.prev;
        map.remove(toRemove.key);
        removeNodeFromList(toRemove);
    }

    private void removeNodeFromList(Node node) {
        Node tmpPrev = node.prev;
        Node tmpNext = node.next;
        tmpNext.prev = tmpPrev;
        tmpPrev.next = tmpNext;
    }

    private void insertToHead(Node node) {
        Node tmpNext = head.next;
        head.next = node;
        tmpNext.prev = node;
        node.next = tmpNext;
        node.prev = head;
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
