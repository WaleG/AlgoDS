package com.example.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}};
        boolean exist = new WordSearch().exist(board, "aaa");
        System.out.println(exist);
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (!isValid(board, i, j) || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        if (exist(board, i + 1, j, word, index + 1, visited) ||
                exist(board, i - 1, j, word, index + 1, visited) ||
                exist(board, i, j + 1, word, index + 1, visited) ||
                exist(board, i, j - 1, word, index + 1, visited)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
