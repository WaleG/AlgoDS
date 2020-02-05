package com.example.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = slow.next;
        tail = reverseList(tail);
        slow.next = null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        while (head != null && tail != null) {
            ListNode tmpHead = head.next;
            ListNode tmpTail = tail.next;
            head.next = tail;
            head.next.next = tmpHead;
            tail = tmpTail;
            head = tmpHead;
        }

        head = dummy.next;
    }

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

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
