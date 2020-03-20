package com.example.dynamicprogramming;

public class MaximalSquare {
    /*
     * Input:
     *
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     *
     * Output: 4
     */

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int res = new MaximalSquare().maximalSquare(matrix);
        System.out.println(res);
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;

        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    // Brute Force
//    public int maximalSquare(char[][] matrix) {
//        int max = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                int curr = max(i, j, i, j, matrix);
//                max = Math.max(curr, max);
//            }
//        }
//        return max;
//    }
//
//    private int max(int fromI, int fromJ, int toI, int toJ, char[][] matrix) {
//        if (toI == matrix.length || toJ == matrix[0].length) return 0;
//        for (int i = fromI; i <= toI; i++) {
//            if (matrix[i][toJ] == '0') return 0;
//        }
//        for (int j = fromJ; j <= toJ; j++) {
//            if (matrix[toI][j] == '0') return 0;
//        }
//        int currCells = toI - fromI + toJ - fromJ + 1;
//        return currCells + max(fromI, fromJ, toI + 1, toJ + 1, matrix);
//    }
}

