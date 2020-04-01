package com.example.ignore.facebook;

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] priority = new int[26];
        for (int i = 0; i < order.length(); i++) {
            priority[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (firstIsLarger(words[i - 1], words[i], priority)) return false;
        }

        return true;
    }

    private boolean firstIsLarger(String first, String second, int[] priority) {
        int fLen = first.length();
        int sLen = second.length();

        for (int i = 0; i < Math.min(fLen, sLen); i++) {
            char fChar = first.charAt(i);
            char sChar = second.charAt(i);
            if (fChar != sChar) {
                return priority[fChar - 'a'] > priority[sChar - 'a'];
            }
        }

        return fLen > sLen; // 'abca' > 'abc';
    }
}
