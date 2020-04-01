package com.example.ignore.facebook;

public class ExcelShitColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        while (n > 0) {
            n--;
            char next = (char) ('A' + n % 26);
            res.append(next);
            n /= 26;
        }

        return res.reverse().toString();
    }
}
