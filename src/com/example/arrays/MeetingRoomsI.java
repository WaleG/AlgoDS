package com.example.arrays;

import java.util.Comparator;
import java.util.List;

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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) return true;
        intervals.sort(Comparator.comparingInt((Interval i) -> i.start));
        int end = intervals.get(0).end;
        for (Interval i : intervals) {
            if (end > i.start) return false;
            end = i.end;
        }
        return true;
    }

    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
