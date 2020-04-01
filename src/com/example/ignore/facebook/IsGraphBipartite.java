package com.example.ignore.facebook;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, i, 1, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int node, int color, int[] colors) {
        if (colors[node] != 0) {
            return colors[node] == color;
        } else {
            colors[node] = color;
            for (int neighbour: graph[node]) {
                if (!dfs(graph, neighbour, -color, colors)) {
                    return false;
                }
            }
            return true;
        }
    }
}
