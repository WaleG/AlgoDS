package com.example.linkedlist;

public class ReverseLinkedList {
//    iterative
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

//    recursive
//    public ListNode reverseList(ListNode head) {
//        if (head == null) return null;
//        return helper(head, null);
//    }
//
//    private ListNode helper(ListNode node, ListNode prev) {
//        if (node.next == null) {
//            node.next = prev;
//            return node;
//        }
//        ListNode next = node.next;
//        node.next = prev;
//        return helper(next, node);
//    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
