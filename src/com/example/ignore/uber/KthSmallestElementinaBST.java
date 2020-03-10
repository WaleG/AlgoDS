package com.example.ignore.uber;

import com.example.trees.bst.RangeSumOfBST;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();

        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();

            if (--k == 0) return root.val;

            root = root.right;
        }

        return -1;
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
