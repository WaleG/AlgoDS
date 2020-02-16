package com.example.design;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);

        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);

        if (node == null) {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            map.put(key, newNode);
            addToFront(newNode);
            if (map.size() > capacity) {
                removeLRUEntry();
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void removeLRUEntry() {
        ListNode tail = this.tail.prev;
        removeFromList(tail);
        map.remove(tail.key);
    }


    private void moveToHead(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }

    private void addToFront(ListNode node) {
        ListNode tmpNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = tmpNext;
        tmpNext.prev = node;
    }

    private void removeFromList(ListNode node) {
        ListNode tmpPrev = node.prev;
        ListNode tmpNext = node.next;

        tmpPrev.next = tmpNext;
        tmpNext.prev = tmpPrev;
    }

    private class ListNode {
        int key;
        int value;

        ListNode prev;
        ListNode next;
    }
}
