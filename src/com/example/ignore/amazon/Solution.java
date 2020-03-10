package com.example.ignore.amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    int islands(int rows, int column, List<List<Integer> > grid)
    {
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    floodFillDFS(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    // METHOD SIGNATURE ENDS

    private void floodFillDFS(int i, int j, List<List<Integer>> grid) {
        if (isFull(i, j, grid)) {
            grid.get(i).set(j, 0);
            floodFillDFS(i + 1, j, grid);
            floodFillDFS(i - 1, j, grid);
            floodFillDFS(i, j + 1, grid);
            floodFillDFS(i, j - 1, grid);
        }
    }

    private boolean isFull(int i, int j, List<List<Integer>> grid) {
        return i >= 0 && i < grid.size() && j >= 0 && j < grid.get(0).size() && grid.get(i).get(j) == 1;
    }
}
