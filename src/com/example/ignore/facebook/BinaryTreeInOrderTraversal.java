package com.example.ignore.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> toProcess = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !toProcess.isEmpty()) {
            while (curr != null) {
                toProcess.push(curr);
                curr = curr.left;
            }
            curr = toProcess.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if (root != null) {
            traverse(root.left, result);
            result.add(root.val);
            traverse(root.right, result);
        }
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        traverse(root, result);
//        return result;
//    }
//
//    private void traverse(TreeNode root, List<Integer> result) {
//        if (root != null) {
//            traverse(root.left, result);
//            result.add(root.val);
//            traverse(root.right, result);
//        }
//    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
