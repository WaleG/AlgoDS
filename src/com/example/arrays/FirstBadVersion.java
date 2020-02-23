package com.example.arrays;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int version = lo + (hi - lo) / 2;
            if (isBadVersion(version)) {
                hi = version;
            } else {
                lo = version + 1;
            }
        }
        return lo;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
