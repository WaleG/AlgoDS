package com.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanicWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < n; i++) {
            dfs(i, 0, Integer.MIN_VALUE, matrix, pacific, directions);
            dfs(i, m - 1, Integer.MIN_VALUE, matrix, atlantic, directions);
        }

        for (int j = 0; j < m; j++) {
            dfs(0, j, Integer.MIN_VALUE, matrix, pacific, directions);
            dfs(n - 1, j, Integer.MIN_VALUE, matrix, atlantic, directions);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int height, int[][] matrix, boolean[][] visited, int[][] directions) {
        if (isValid(i, j, height, matrix, visited)) {
            visited[i][j] = true;
            for (int[] d : directions) {
                dfs(i + d[0], j + d[1], matrix[i][j], matrix, visited, directions);
            }
        }
    }

    private boolean isValid(int i, int j, int height, int[][] matrix, boolean[][] visited) {
        return i >= 0 && i < matrix.length &&
                j >= 0 && j < matrix[0].length &&
                !visited[i][j] &&
                matrix[i][j] >= height;
    }
}
