package com.example.ignore.amazon;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(5);
        p.left = new TreeNode(6);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(7);
        p.right.right = new TreeNode(4);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(0);
        q.right = new TreeNode(8);

        TreeNode root = new TreeNode(3);
        root.left = p;
        root.right = q;

        TreeNode res = new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, p, q);
        System.out.println(res);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = pathToNode(root, p, new ArrayList<>());
        List<TreeNode> pathToQ = pathToNode(root, q, new ArrayList<>());

        return lca(pathToP, pathToQ);
    }

    private TreeNode lca(List<TreeNode> pathToP, List<TreeNode> pathToQ) {
        if (pathToP.size() > pathToQ.size()) return lca(pathToQ, pathToP);
        Set<Integer> s = new HashSet<>();
        for (TreeNode t: pathToP) {
            s.add(t.val);
        }
        for (int i = pathToQ.size() - 1; i >= 0; i--) {
            TreeNode cand = pathToQ.get(i);
            if (s.contains(cand.val)) {
                return cand;
            }
        }
        return null;
    }

    private List<TreeNode> pathToNode(TreeNode root, TreeNode p, List<TreeNode> pathSoFar) {
       if (root == null) return pathSoFar;
        pathSoFar.add(root);
       if (root.val == p.val) {
           return pathSoFar;
       } else {
           List<TreeNode> cand = pathToNode(root.left, p, pathSoFar);
           if (cand.get(cand.size() - 1).equals(p)) return cand;
           cand = pathToNode(root.right, p, pathSoFar);
           if (cand.get(cand.size() - 1).equals(p)) return cand;
           pathSoFar.remove(cand.size() - 1);
           return pathSoFar;
       }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
