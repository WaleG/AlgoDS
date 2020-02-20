package com.example.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger nestedInteger: nestedList) {
            sum += levelSum(nestedInteger, 1);
        }
        return sum;
    }

    private int levelSum(NestedInteger nestedInteger, int level) {
        if (nestedInteger == null) return 0;
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * level;
        } else {
            if (nestedInteger.getList() == null) return 0;
            int sum = 0;
            for (NestedInteger next: nestedInteger.getList()) {
                sum += levelSum(next, level + 1);
            }
            return sum;
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
