package com.example.ignore.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CustomSortString {
    public static void main(String[] args) {
        String S = "cba";
        String T = "abcd";
        String res = new CustomSortString().customSortString(S, T);
        System.out.println(res);
    }
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) { ++count[c - 'a']; }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) { sb.append(c); }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { sb.append(c); }    // group chars in T but not in S.
        }
        return sb.toString();
    }

//    public String customSortString(String S, String T) {
//        int[] priority = new int[26];
//        int p = 1;
//        for (char c : S.toCharArray()) {
//            priority[c - 'a'] = p++;
//        }
//
//        List<Character> list = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < T.length(); i++) {
//            char c = T.charAt(i);
//            if (priority[c - 'a'] == 0) sb.append(c);
//            else list.add(c);
//        }
//        list.sort(Comparator.comparingInt((Character c) -> priority[c - 'a']));
//        list.forEach(sb::append);
//        return sb.toString();
//    }
}
