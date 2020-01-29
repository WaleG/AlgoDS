package com.example.trees;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(-1);
        int result = new BinaryTreeMaximumPathSum().maxPathSum(t);
        System.out.println(result);
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxSum(node.left));
        int right = Math.max(0, maxSum(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
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
