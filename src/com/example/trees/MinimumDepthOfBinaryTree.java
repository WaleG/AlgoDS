package com.example.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    //DFS
    // public int minDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     if (root.right == null)  return minDepth(root.left) + 1;
    //     if (root.left == null) return minDepth(root.right) + 1;
    //     return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    // }

    //BFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode n = q.remove();
                if (n.left == null && n.right == null) return level;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
                size--;
            }
            level++;
        }
        return level;
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
