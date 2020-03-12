package com.example.ignore.amazon;

public class MinStack {
    /** initialize your data structure here. */
    private Node node;

    public MinStack() {

    }

    public void push(int x) {
        int min = node == null ? x : Math.min(x, node.min);
        node = new Node(x, min, node);
    }

    public void pop() {
        if (node == null) throw new ArrayIndexOutOfBoundsException();
        node = node.next;
    }

    public int top() {
        if (node == null) throw new ArrayIndexOutOfBoundsException();
        return node.val;
    }

    public int getMin() {
        if (node == null) throw new ArrayIndexOutOfBoundsException();
        return node.min;
    }

    private static class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
