package com.example.ignore.amazon;

public class DiameterOfABinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxHolder = {0};
        maxDepth(root, maxHolder);
        return maxHolder[0];
    }

    private int maxDepth(TreeNode root, int[] maxHolder) {
        if (root == null) return 0;
        int left = maxDepth(root, maxHolder);
        int right = maxDepth(root, maxHolder);

        maxHolder[0] = Math.max(maxHolder[0], left + right);

        return Math.max(left, right) + 1;
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
