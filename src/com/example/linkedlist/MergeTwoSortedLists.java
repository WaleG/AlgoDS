package com.example.linkedlist;

public class MergeTwoSortedLists {
//    iterative
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;
        while (l1 != null && l2 != null) {
            ListNode next;
            if (l1.val > l2.val) {
                next = l2;
                l2 = l2.next;
            } else {
                next = l1;
                l1 = l1.next;
            }
            curr.next = next;
            curr = next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return preHead.next;
    }

    //    recursive
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) return null;
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        if (l1.val > l2.val) {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        } else {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }
//    }

    /*
    Input: 1->2->4,
           1->3->4
    Output: 1->1->2->3->4->4
     */

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
