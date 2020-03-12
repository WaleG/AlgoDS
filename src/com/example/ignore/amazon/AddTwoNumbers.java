package com.example.ignore.amazon;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int curry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + curry;
            curry = val / 10;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + curry;
            curry = val / 10;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + curry;
            curry = val / 10;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            l2 = l2.next;
        }
        if (curry == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
