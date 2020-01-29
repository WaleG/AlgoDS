package com.example.trees;

import java.util.Stack;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null ^ q == null) return false;

        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        ps.push(p);
        qs.push(q);
        while (!ps.isEmpty() && !qs.isEmpty()) {
            p = ps.pop();
            q = qs.pop();

            if (p.val != q.val) return false;

            if ((p.left == null) == (q.left == null)) {
                if (p.left != null) {
                    ps.push(p.left);
                    qs.push(q.left);
                }
            } else {
                return false;
            }

            if ((p.right == null) == (q.right == null)) {
                if (p.right != null) {
                    ps.push(p.right);
                    qs.push(q.right);
                }
            } else {
                return false;
            }
        }

        return ps.isEmpty() && qs.isEmpty();
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
