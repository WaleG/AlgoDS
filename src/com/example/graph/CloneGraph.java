package com.example.graph;

import java.util.*;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    public Node dfs(Node node, Map<Integer, Node> seen) {
        if (node == null) return null;

        if (seen.containsKey(node.val)) {
            return seen.get(node.val);
        }

        Node copy = new Node(node.val);
        seen.put(node.val, copy);

        for (Node neighbor: node.neighbors) {
            Node newNeighbor = dfs(neighbor, seen);
            copy.neighbors.add(newNeighbor);
        }

        return copy;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
