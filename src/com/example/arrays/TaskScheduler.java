package com.example.arrays;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int time : count) {
            if (time > 0) {
                pq.add(time);
            }
        }

        int total = 0;
        while (!pq.isEmpty()) {
            int i = 0;
            List<Integer> tmp = new LinkedList<>();
            while (i <= n) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > 1) {
                        tmp.add(pq.remove() - 1);
                    } else {
                        pq.remove();
                    }
                }
                total++;
                if (pq.isEmpty() && tmp.size() == 0) {
                    break;
                }
                i++;
            }
            pq.addAll(tmp);
        }

        return total;
    }
}
