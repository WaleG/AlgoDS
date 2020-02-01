package com.example.trees;

import java.util.*;

public class ConstructFromPreorderAndPostorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Queue<Integer> q = new LinkedList<>();
        for (int e: preorder) {
            q.add(e);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build( 0, inorder.length - 1, q, map);
    }

    private TreeNode build(int inStart, int inEnd, Queue<Integer> q, Map<Integer, Integer> map) {
        if (q.isEmpty() || inStart > inEnd) {
            return null;
        }

        int val = q.poll();
        int inIndex = map.get(val);
        int numsOnLeft = inIndex - inStart;

        TreeNode root = new TreeNode(val);
        root.left = build(inStart, inIndex - 1, q, map);
        root.right = build(inIndex + 1, inEnd, q, map);
        return root;
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
