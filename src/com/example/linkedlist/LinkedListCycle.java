package com.example.linkedlist;

public class LinkedListCycle {
//    iterative
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

//    recursive
//    public boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) return false;
//        return helper(head.next, head.next.next);
//    }
//
//    private boolean helper(ListNode slow, ListNode fast) {
//        if (fast == null || fast.next == null || fast.next.next == null) return false;
//        if (fast == slow) return true;
//        return helper(slow.next, fast.next.next);
//    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
