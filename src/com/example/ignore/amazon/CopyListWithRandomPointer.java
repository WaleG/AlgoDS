package com.example.ignore.amazon;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        return copy(head, new HashMap<>());
    }

    private Node copy(Node head, Map<Node, Node> map) {
        if (head == null) return null;
        Node currentCopy = new Node(head.val);
        map.put(head, currentCopy);
        currentCopy.next = copy(head.next, map);
        currentCopy.random = map.get(head.random);
        return currentCopy;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
