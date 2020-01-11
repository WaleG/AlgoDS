package com.example.heap;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListHead> pq = new PriorityQueue<>(ListHead::compareTo);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) pq.offer(new ListHead(i, lists[i]));
        }


        ListNode root = new ListNode(0);
        ListHead head;

        ListNode prev = root;
        while (!pq.isEmpty()) {
            head = pq.poll();
            prev.next = new ListNode(head.value.val);
            prev = prev.next;
            if (head.value.next != null) {
                pq.offer(new ListHead(head.index, head.value.next));
            }
        }
        return root.next;
    }

    private static class ListHead implements Comparable<ListHead> {
        int index;
        ListNode value;

        ListHead(int index, ListNode value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(ListHead o) {
            return Integer.compare(this.value.val, o.value.val);
        }
    }
}
