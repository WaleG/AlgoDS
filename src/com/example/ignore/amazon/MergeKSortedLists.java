package com.example.ignore.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                q.add(listNode);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (!q.isEmpty()) {
            ListNode node = q.remove();
            if (node.next != null) {
                q.add(node.next);
            }
            curr.next = node;
            curr = curr.next;
        }
        return head.next;
    }

    /*
    Input:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    Output: 1->1->2->3->4->4->5->6
     */

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
