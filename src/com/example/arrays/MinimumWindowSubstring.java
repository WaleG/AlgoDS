package com.example.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = new MinimumWindowSubstring().minWindow(s, t);
        System.out.println(res);
    }

    public String minWindow(String s, String t) {
        int i = 0, j = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        Map<Character, Integer> freq = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            int count = freq.getOrDefault(t.charAt(k), 0);
            freq.put(t.charAt(k), count + 1);
        }

        int required = freq.size();
        int current = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        while (j < s.length()) {
            char c = s.charAt(j);

            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (freq.containsKey(c) && (windowCounts.get(c).equals(freq.get(c)))) {
                current++;
            }

            while (i <= j && current == required) {
                if (j - i + 1 < minLen) {
                    minStart = i;
                    minLen = j - i + 1;
                }

                c = s.charAt(i);
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (freq.containsKey(c) && (windowCounts.get(c).compareTo(freq.get(c)) < 0)) {
                    current--;
                }
                i++;
            }

            j++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    /*
    Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC"

    map: A->1,B->1,C->1
    c=3
    i=0, j=1 c=2 "A"
    i=0, j=6 minLen=j-i=6
     */
}
