package com.example.arrays;

import java.util.Arrays;

public class MeetingRoomsI {
    /*
    For example,
    Given [ [0, 30], [5, 10], [15, 20] ],
    return false.
    0----5----10----15----20----25----30
    ^                                  ^
         ^    ^
                    ^     ^
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0) return true;
        Arrays.sort(intervals);
        int end = intervals[0].to;
        for (Interval i : intervals) {
            if (end > i.from) return false;
            end = i.to;
        }
        return true;
    }

    private static class Interval implements Comparable<Interval> {
        int from;
        int to;

        public Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.from, o.from);
        }
    }
}
