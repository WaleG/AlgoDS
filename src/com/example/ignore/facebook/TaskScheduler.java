package com.example.ignore.facebook;

import java.util.*;

public class TaskScheduler {
    /*
    Given a char array representing tasks CPU need to do.
    It contains capital letters A to Z where different letters represent different tasks.
    Tasks could be done without original order.
    Each task could be done in one interval.
    For each interval, CPU could finish one task or just be idle.

    However, there is a non-negative cooling interval n that means between two same tasks,
    there must be at least n intervals that CPU are doing different tasks or just be idle.

    You need to return the least number of intervals the CPU will take to finish all the given tasks.

    Example:

    Input: tasks = ["A","A","A","B","B","B"], n = 2
    Output: 8
    Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     */

    /*
    queue = ["A", "A", "A"]
    total = 2
    prevLetter = 'A'
    timeout = 2
    tasks = ["B","B"]
     */

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task: tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int time: count) {
            if (time > 0) q.add(time);
        }

        int total = 0;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!q.isEmpty()) {
                    int remaining = q.remove();
                    if (remaining > 1) tmp.add(remaining - 1);
                }
                total++;
                if (q.isEmpty() && tmp.isEmpty()) break;
            }
            q.addAll(tmp);
        }
        return total;
    }
}
