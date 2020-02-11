package com.example.trees;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenedEnd(root);
    }

    private TreeNode flattenedEnd(TreeNode node) {
        if (node == null) return null;
        if (node.right == null) {
            TreeNode leftEnd = flattenedEnd(node.left);
            if (leftEnd == null) {
                return node;
            }
            node.right = node.left;
            node.left = null;
            return leftEnd;
        } else {
            TreeNode rightEnd = flattenedEnd(node.right);
            TreeNode leftEnd = flattenedEnd(node.left);
            if (leftEnd == null) {
                return rightEnd;
            }
            TreeNode prevRight = node.right;
            node.right = node.left;
            node.left = null;
            leftEnd.right = prevRight;
            return rightEnd;
        }
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
