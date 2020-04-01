package com.example.ignore.facebook;

public class BinaryTreeMaxPathSum {
    /*
    Given a non-empty binary tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes
    from some starting node to any node in the tree along the parent-child connections.
    The path must contain at least one node and does not need to go through the root.
     */

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(0, maxSum(root.left));
        int rightMax = Math.max(0, maxSum(root.right));

        max = Math.max(max, leftMax + rightMax + root.val);

        return Math.max(leftMax, rightMax) + root.val;
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
