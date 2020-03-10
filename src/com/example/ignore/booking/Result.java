package com.example.ignore.booking;

import java.util.*;

public class Result {

    /*
     * Complete the 'countNonUnique' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static int countNonUnique(List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) return 0;

        Map<Integer, Integer> seen = new HashMap<>();
        int count = 0;

        for(int number: numbers) {
           int frequency = seen.getOrDefault(number, 0);
           if (frequency == 0) {
               seen.put(number, 1);
           } else if (frequency == 1) {
               seen.put(number, frequency + 1);
               count++;
           }
           //we don't need to count more than 2 occurrences
        }

        return count;
    }

}
