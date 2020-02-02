package com.example.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(comparingInt((ListNode a) -> a.val));
        for (ListNode node: lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while (!pq.isEmpty()) {
            ListNode node = pq.remove();
            curr.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            curr = curr.next;
        }
        return result.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
