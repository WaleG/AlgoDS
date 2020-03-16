package com.example.ignore.amazon;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = isFirstRowZero(matrix);
        boolean isFirstColumnZero = isFirstColumnZero(matrix);

        findZeroRowsAndColumns(matrix);
        fillZeroRowsAndColumns(matrix);

        if (isFirstRowZero) setFirstRowZero(matrix);
        if (isFirstColumnZero) setFirstColumnZero(matrix);
    }

    private void setFirstRowZero(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }
    }

    private void setFirstColumnZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }

    private void fillZeroRowsAndColumns(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void findZeroRowsAndColumns(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
    }

    private boolean isFirstRowZero(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isFirstColumnZero(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                return true;
            }
        }
        return false;
    }
}
