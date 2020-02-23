package com.example.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        return copy(head, new HashMap<>());
    }

    private Node copy(Node node, Map<Node, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        Node copy = new Node(node.val);
        map.put(node, copy);
        copy.next = copy(node.next, map);
        copy.random = copy(node.random, map);
        return copy;
    }


    //      Definition for singly-linked list with a random pointer.
    private static class Node {
        int val;
        Node next;
        Node random;

        Node(int x) {
            this.val = x;
            this.next = null;
            this.random = null;
        }
    }
}
