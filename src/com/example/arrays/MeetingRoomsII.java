package com.example.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    /*
    For example,
    Given [ [0, 30], [5, 10], [15, 20] ],
    return 2.
    0----5----10----15----20----25----30
    ^                                  ^
         ^    ^
                    ^     ^
     */
    public int minMeetingRoomsII(Interval[] intervals) {
        Arrays.sort(intervals);

        int count = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Interval i : intervals) {
            if (heap.isEmpty()) {
                count++;
            } else {
                if (heap.peek() >= i.from) {
                    heap.poll();
                } else {
                    count++;
                }

            }
            heap.offer(i.to);
        }
        return count;
    }

    private static class Interval implements Comparable<Interval> {
        int from;
        int to;

        public Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Interval that) {
            return Integer.compare(this.from, that.from);
        }
    }
}
