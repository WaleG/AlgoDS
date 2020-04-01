package com.example.ignore.facebook;

public class CustomSortOrderString {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (int i = 0; i < T.length(); i++) {
            count[T.charAt(i) - 'a']++;
        }

        StringBuilder sortedStr = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char letter = S.charAt(i);
            while (count[letter - 'a']-- > 0) {
                sortedStr.append(letter);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (count[i]-- > 0) {
                sortedStr.append((char) (i + 'a'));
            }
        }

        return sortedStr.toString();
    }
}
