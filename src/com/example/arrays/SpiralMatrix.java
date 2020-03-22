package com.example.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();

        int n = matrix[0].length;
        int m = matrix.length;
        List<Integer> result = new ArrayList<>(n * m);

        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;

        while (l <= r && t <= b) {
            //add row l->r
            for (int col = l; col <= r; col++) {
                result.add(matrix[t][col]);
            }

            //add col t->b
            for (int row = t + 1; row <= b; row++) result.add(matrix[row][r]);

            if (l < r && b > t) {
                //add row r->l
                for (int col = r - 1; col > l; col--) result.add(matrix[b][col]);

                //add col b->t
                for (int row = b; row > t; row--) result.add(matrix[row][l]);

            }
            l++;
            r--;
            t++;
            b--;
        }

        return result;
    }
}
