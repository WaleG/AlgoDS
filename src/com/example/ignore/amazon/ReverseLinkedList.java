package com.example.ignore.amazon;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next = new ListNode(5);
        ListNode res = new ReverseLinkedList().reverseList(head);
        System.out.println(res);
    }

    public ListNode reverseList(ListNode head) {
        return recursive(head, null);
    }

    private ListNode iterative(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmpNext = head.next;
            head.next = prev;
            prev = head;
            head = tmpNext;
        }
        return prev;
    }

    private ListNode recursive(ListNode head, ListNode prev) {
        if (head == null) return prev;
        ListNode tmpNext = head.next;
        head.next = prev;
        return recursive(tmpNext, head);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
