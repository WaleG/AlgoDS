package com.example.arrays;

import java.util.*;

public class MultiplyTwoArbitraryPrecisionIntegers {
    public static void main(String[] args) {
// (1,9,3,7,0,7,7,2,1} and (-7,6,1,8,3,8,2,5,7,2,8,7),
// your function should return (-1,4,7,5,7,3,9,5,2,5,8,9,6,7,6,4,1,2,9,2,7).
        List<Integer> a = Arrays.asList(1, 9, 3, 7, 0, 7, 7, 2, 1);
        List<Integer> b = Arrays.asList(-7, 6, 1, 8, 3, 8, 2, 5, 7, 2, 8, 7);
        List<Integer> result = multiply(a, b);
        System.out.println(result);
    }

    public static List<Integer> multiply(List<Integer> a, List<Integer> b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;

        Map<Integer, Integer> map = new HashMap<>();
        int sign = (((a.get(0)) < 0) ^ (b.get(0) < 0)) ? -1 : 1;
        int tmp = 0;

        for (int i = a.size() - 1; i >= 0; i--) {
            for (int j = b.size() - 1; j >= 0; j--) {
                tmp = map.getOrDefault(i + j + 1, 0) + Math.abs(a.get(i) * b.get(j));
                map.put(i + j + 1, tmp % 10);
                map.put(i + j, map.getOrDefault(i + j, 0) + tmp / 10);
            }
        }

        List<Integer> result = new ArrayList<>(Collections.nCopies(map.size(), 0));
        for (int key : map.keySet()) {
            result.set(key, map.get(key));
        }
        result.set(0, result.get(0) * sign);
        return result;
    }
}
