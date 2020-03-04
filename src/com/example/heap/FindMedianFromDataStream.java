package com.example.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private PriorityQueue<Integer> upper;
    private PriorityQueue<Integer> lower;

    /**
     * initialize your data structure here.
     */
    public FindMedianFromDataStream() {
        upper = new PriorityQueue<>();
        lower = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        lower.offer(num);
        upper.offer(lower.remove());
        if (upper.size() > lower.size()) {
            lower.offer(upper.poll());
        }
    }

    public double findMedian() {
        if(upper.size() == lower.size()) return (upper.element() + lower.element()) / 2.0;
        return lower.size();
    }
}
