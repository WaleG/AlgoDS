package com.example.dynamicprogramming;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] distance = new int[m + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            distance[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            distance[i][0] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    distance[i][j] = distance[i-1][j-1];
                }else {
                    int insertion = distance[i - 1][j];
                    int deletion = distance[i][j - 1];
                    int replacement = distance[i - 1][j - 1];
                    distance[i][j] = 1 + Math.min(replacement, Math.min(insertion, deletion));
                }
            }
        }
        return distance[m][n];
    }
}
