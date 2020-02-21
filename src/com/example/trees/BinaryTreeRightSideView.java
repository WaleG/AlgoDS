package com.example.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return null;
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                TreeNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (size == 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
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
