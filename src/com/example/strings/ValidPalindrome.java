package com.example.strings;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = new ValidPalindrome().isPalindrome(s);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        char[] str = s.toLowerCase().toCharArray();
        int lo = 0;
        int hi = str.length - 1;
        while (lo < hi) {
            if (isNotAlphanum(str[lo])) lo++;
            else if (isNotAlphanum(str[hi])) hi--;
            else if (str[lo++] != str[hi--]) return false;
        }
        return true;
    }

    private boolean isNotAlphanum(char c) {
        c = Character.toLowerCase(c);
        return (c < 'a' || c > 'z') && (c < '0' || c > '9');
    }
}
