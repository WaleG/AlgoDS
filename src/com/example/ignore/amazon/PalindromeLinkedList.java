package com.example.ignore.amazon;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        boolean isP = new PalindromeLinkedList().isPalindrome(one);
        System.out.println(isP);
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
