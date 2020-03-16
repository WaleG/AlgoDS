package com.example.ignore.amazon;

public class SearchA2DMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
//        int[][] matrix = {{1, 3}};
        boolean found3 = new SearchA2DMatrix().searchMatrix(matrix, 23);
        System.out.println(found3);
//        boolean found5 = new SearchA2DMatrix().searchMatrix(matrix, 5);
//        System.out.println(found5);
//        boolean found20 = new SearchA2DMatrix().searchMatrix(matrix, 20);
//        System.out.println(found20);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = findRow(matrix, target);
        if (row == -1) return false;
        int col = findColumn(matrix, row, target);
        return col != -1;
    }

    private int findColumn(int[][] matrix, int row, int target) {
        int lo = 0;
        int hi = matrix[0].length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] == target) return mid;
            else if (matrix[row][mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    private int findRow(int[][] matrix, int target) {
        int n = matrix[0].length - 1;
        int lo = 0;
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n] >= target) return mid;
            else if (matrix[mid][n] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
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
