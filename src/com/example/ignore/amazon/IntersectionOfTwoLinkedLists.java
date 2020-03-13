package com.example.ignore.amazon;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }

    /**
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * Output: Reference of the node with value = 8
     * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
     * From the head of A, it reads as [4,1,8,4,5].
     * From the head of B, it reads as [5,0,1,8,4,5].
     * There are 2 nodes before the intersected node in A;
     * There are 3 nodes before the intersected node in B.
     */

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
