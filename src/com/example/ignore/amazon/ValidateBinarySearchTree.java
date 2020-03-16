package com.example.ignore.amazon;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        boolean isValid = true;
        if (root.left != null) {
            isValid = isValidBST(root.left, min, root.val);
        }
        if (root.right != null) {
            isValid = isValid && isValidBST(root.right, root.val, max);
        }
        return isValid;
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
