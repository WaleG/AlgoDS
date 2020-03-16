package com.example.ignore.amazon;

import java.util.Arrays;

public class RotateImage {
        /*
     0  1  2  3
  0 [1, 2, 3, 4]
  1 [5, 6, 7, 8]
  2 [4, 3, 2, 1]
  3 [8, 7, 6, 5]
     */

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new RotateImage().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void rotate(int[][] matrix) {
        flipVertical(matrix);
        transpose(matrix);
    }

    private void flipVertical(int[][] m) {
        for (int i = 0; i < m.length / 2; i++) {
            for (int j = 0; j < m[0].length; j++) {
                swap(m, i, j, m.length - i - 1, j);
            }
        }
    }

    private void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m[0].length; j++) {
                swap(m, i, j, j, i);
            }
        }
    }

    private void swap(int[][] m, int i1, int j1, int i2, int j2) {
        int tmp = m[i1][j1];
        m[i1][j1] = m[i2][j2];
        m[i2][j2] = tmp;
    }
}
