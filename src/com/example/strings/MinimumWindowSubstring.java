package com.example.strings;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String result = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }

    /*
    "ADOBECODEBANC"
      ^          ^
    "ABC"D
    [000]1
    c = 0
    l = 1
    r = 12

    minl = 10000
    mins = 1

    r - l = 6

    mins = 0
    minl = 6
     */
    public String minWindow(String s, String pattern) {
        int[] mapP = new int[128];
        for (char c : pattern.toCharArray()) {
            mapP[c - '0']++;
        }

        int counter = pattern.length();
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0;

        int i;
        while (right < s.length()) {
            i = s.charAt(right) - '0';
            if (mapP[i] > 0) {
                counter--;
            }
            mapP[i]--;
            right++;
            while (counter == 0) {
                if (right - left < minLen) {
                    minStart = left;
                    minLen = right - left;
                }
                i = s.charAt(left) - '0';
                mapP[i]++;
                if (mapP[i] > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    /*
    Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC"
     */
}
