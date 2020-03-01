package com.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;

        List r = new NQueens().solveNQueens(n);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(n, 0, new ArrayList<>(), result, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return result;
    }

    private void backtrack(
            int n,
            int rowNum,
            List<String> cur,
            List<List<String>> result,
            boolean[] col,
            boolean[] d1,
            boolean[] d2
    ) {
        if (rowNum == n) {
            result.add(new ArrayList<>(cur));
        } else {
            for (int j = 0; j < n; j++) {
                if (!col[j] && !d1[rowNum + j] && !d2[rowNum - j + n - 1]) {
                    char[] row = new char[n];
                    Arrays.fill(row, '.');

                    row[j] = 'Q';
                    col[j] = true;
                    d1[rowNum + j] = true;
                    d2[rowNum - j + n - 1] = true;

                    String rowStr = new String(row);
                    cur.add(rowStr);

                    backtrack(n, rowNum + 1, cur, result, col, d1, d2);

                    cur.remove(cur.size() - 1);

                    row[j] = '.';
                    col[j] = false;
                    d1[rowNum + j] = false;
                    d2[rowNum - j + n - 1] = false;
                }
            }
        }
    }
}
