package com.example.ignore.amazon;

import java.util.Arrays;

public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        new GameOfLife().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

    private int dead = 0;
    private int live = 1;
    private int toDie = -1;
    private int toLive = 2;

    public void gameOfLife(int[][] board) {
        calculateNextState(board);
        applyNextState(board);
    }

    private void calculateNextState(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int neighbours = countNeighbours(board, row, col);
                if (board[row][col] == dead && neighbours == 3) {
                    board[row][col] = toLive;
                } else if (board[row][col] == live) {
                    if (neighbours != 2 && neighbours != 3) {
                        board[row][col] = toDie;
                    }
                }
            }
        }
    }

    private void applyNextState(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == toDie) board[row][col] = dead;
                if (board[row][col] == toLive) board[row][col] = live;
            }
        }
    }

    private int countNeighbours(int[][] board, int i, int j) {
        int neighbours = 0;
        for (int row = Math.max(i - 1, 0); row <= Math.min(i + 1, board.length - 1); row++) {
            for (int col = Math.max(j - 1, 0); col <= Math.min(j + 1, board[0].length - 1); col++) {
                if (board[row][col] == live || board[row][col] == toDie) neighbours++;
            }
        }
        if (board[i][j] == live || board[i][j] == toDie) neighbours--;
        return neighbours;
    }
}
