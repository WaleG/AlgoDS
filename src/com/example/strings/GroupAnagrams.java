package com.example.strings;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<List<String>> result = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int i;
        int[] arr;
        for (String str : strs) {
            arr = new int[26];
            for (char c : str.toCharArray()) {
                i = c - 'a';
                arr[i]++;
            }
            String key = Arrays.toString(arr);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }
}
