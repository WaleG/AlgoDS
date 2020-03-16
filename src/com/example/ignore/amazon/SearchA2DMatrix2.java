package com.example.ignore.amazon;

public class SearchA2DMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        boolean found5 = new SearchA2DMatrix2().searchMatrix(matrix, 5);
        System.out.println(found5);
        boolean found20 = new SearchA2DMatrix2().searchMatrix(matrix, 20);
        System.out.println(found20);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        return searchMatrix(matrix, target, 0, matrix[0].length - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int row, int col) {
        if (row == matrix.length || col < 0) return false;
        if (matrix[row][col] == target) return true;
        if (target > matrix[row][col]) return searchMatrix(matrix, target, row + 1, col);
        else return searchMatrix(matrix, target, row, col - 1);
    }

    /**
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     */
}
