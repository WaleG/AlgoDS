package com.example.ignore.amazon;

import java.util.Arrays;

public class MinimizeCashFlow {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0},
        };

        int[][] minGraph = minimumCashFlow(graph);

        System.out.println(Arrays.deepToString(minGraph));
    }

    public static int[][] minimumCashFlow(int[][] graph) {
        int[] amount = calculateNetAmount(graph);
        int[][] minGraph = new int[graph.length][graph[0].length];
        minimumCashFlow(amount, minGraph);
        return minGraph;
    }

    private static void minimumCashFlow(int[] amount, int[][] graph) {
        int maximumCreditPerson = getMaxPerson(amount);
        int maximumDebitPerson = getMinPerson(amount);

        if (amount[maximumCreditPerson] == 0 && amount[maximumDebitPerson] == 0) return;

        int min = Math.min(-amount[maximumDebitPerson], amount[maximumCreditPerson]);

        amount[maximumDebitPerson] += min;
        amount[maximumCreditPerson] -= min;

        graph[maximumDebitPerson][maximumCreditPerson] = min;

        minimumCashFlow(amount, graph);
    }

    private static int getMaxPerson(int[] amount) {
        int maxPerson = 0;
        for (int i = 1; i < amount.length; i++) {
            if (amount[maxPerson] < amount[i]) maxPerson = i;
        }
        return maxPerson;
    }

    private static int getMinPerson(int[] amount) {
        int minPerson = 0;
        for (int i = 1; i < amount.length; i++) {
            if (amount[minPerson] > amount[i]) minPerson = i;
        }
        return minPerson;
    }

    private static int[] calculateNetAmount(int[][] graph) {
        int[] amount = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                /*
                 * Here  graph[j][i] => incoming amount
                 * and  graph[i][j] => outgoing amount
                 */
                amount[i] += graph[j][i] - graph[i][j];
            }
        }
        return amount;
    }
}
