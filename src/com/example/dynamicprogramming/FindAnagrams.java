package com.example.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> res = new FindAnagrams().findAnagrams(s, p);
        System.out.println(res);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pChars = new int[26];
        int[] sChars = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pChars[p.charAt(i) - 'a']++;
            sChars[s.charAt(i) - 'a']++;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (pChars[i] - sChars[i] != 0) diff ++;
        }
        if (diff == 0) result.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            int remove = s.charAt(i - p.length()) - 'a';
            sChars[remove]--;
            if (pChars[remove] - sChars[remove] == 1) diff++; //we removed same char from, so difference is bigger now
            if (sChars[remove] == pChars[remove]) diff--;

            int add = s.charAt(i) - 'a';
            sChars[add]++;
            if (pChars[add] - sChars[add] == -1) diff++; //we added extra same char to s, so difference is bigger now
            if (sChars[add] == pChars[add]) diff--;

            if (diff == 0) result.add(i - p.length() + 1);
        }

        return result;
    }
}
