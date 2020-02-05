package com.example.linkedlist;

public class RemoveNthNodeFromEnd {
    //    one pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while (n >= 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
//    two pass
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int size = 0;
//        ListNode cur = head;
//        while (cur != null) {
//            size++;
//            cur = cur.next;
//        }
//        //size = 5 s - n = 3
//        cur = head;
//        int k = size - n;
//        if (k == 0) return head.next;
//        while (k > 1) {
//            cur = cur.next;
//            k--;
//        }
//        cur.next = cur.next.next;
//        return head;
//    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
