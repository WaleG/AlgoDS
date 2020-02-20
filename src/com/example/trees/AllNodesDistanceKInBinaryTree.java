package com.example.trees;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, null, map);
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> seen = new HashSet<>();
        int level = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                TreeNode current = q.remove();
                seen.add(current);
                if (level == K) {
                    result.add(current.val);
                } else if (level > K) {
                    break;
                } else {
                    if (current.left != null && !seen.contains(current.left)) {
                        q.add(current.left);
                    }
                    if (current.right != null && !seen.contains(current.right)) {
                        q.add(current.right);
                    }
                    TreeNode parent = map.get(current);
                    if (parent != null && !seen.contains(parent)) {
                        q.add(parent);
                    }
                }
            }
            level++;
        }
        return result;
    }

    private void dfs(TreeNode child, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (child == null) return;
        map.put(child, parent);
        dfs(child.left, child, map);
        dfs(child.right, child, map);
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
