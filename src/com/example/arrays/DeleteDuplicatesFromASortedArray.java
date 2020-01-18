package com.example.arrays;

import java.util.List;

public class DeleteDuplicatesFromASortedArray {
    public static int removeDuplicates(List<Integer> a) {
        if (a == null) return 0;
        int n = a.size();
        if (n < 2) return n;
        int insert = 1;
        for (int i = 1; i < n; i++) {
            if (a.get(i) > a.get(i - 1)) {
                a.set(insert++, a.get(i));
            }
        }
        return insert;
    }
}
