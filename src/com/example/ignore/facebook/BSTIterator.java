package com.example.ignore.facebook;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> state;

    public BSTIterator(TreeNode root) {
        this.state = new Stack<>();
        this.leftInorder(root);
    }

    private void leftInorder(TreeNode curr) {
        while (curr != null) {
            this.state.push(curr);
            curr = curr.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode smallest = state.pop();
        if (smallest.right != null) {
            this.leftInorder(smallest.right);
        }
        return smallest.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !state.isEmpty();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
