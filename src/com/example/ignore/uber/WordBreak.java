package com.example.ignore.uber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] canBeSegmented = new boolean[s.length() + 1];
        canBeSegmented[0] = true;
        Set<String> dict = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (canBeSegmented[j] && dict.contains(word)) {
                    canBeSegmented[i] = true;
                    break;
                }
            }
        }

        return canBeSegmented[s.length()];
    }
}
