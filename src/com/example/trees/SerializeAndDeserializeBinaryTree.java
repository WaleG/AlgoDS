package com.example.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X,";

        String leftS = serialize(root.left);
        String rightS = serialize(root.right);

        return root.val + "," + leftS + rightS;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(nodes);
    }

    public TreeNode helper(Queue<String> nodesLeft) {
        if (nodesLeft.isEmpty()) return null;
        String token = nodesLeft.remove();
        if (token.equals("X")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(token));
            root.left = helper(nodesLeft);
            root.right = helper(nodesLeft);
            return root;
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
