package com.example.linkedlist;

public class InsertIntoACyclicSortedList {
    public ListNode insert(ListNode node, int insertVal) {
        ListNode insert = new ListNode(insertVal);
        if (node == null) {
            insert.next = insert;
            return insert;
        }


        ListNode p = node;
        while (!(p.val < p.next.val && p.val <= insertVal && insertVal <= p.next.val)
                && !(p.val > p.next.val && !(insertVal < p.val && insertVal > p.next.val))
                && !(p.val == p.next.val && !(p.next != node && p.val != insertVal))
        ) {
            p = p.next;
        }
        insert.next = p.next;
        p.next = insert;
        return insert;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
