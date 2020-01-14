package com.example.strings;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int r = new LongestRepeatingCharacterReplacement().characterReplacement(s, 1);
        System.out.println(r);
    }

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[128];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end)]);
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start)]--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
