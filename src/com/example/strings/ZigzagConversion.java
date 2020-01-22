package com.example.strings;

public class ZigzagConversion {
    public String convert(String s, int nRows) {
        int len = s.length();
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();

        int i = 0;
        while (i < len) {
            for (int row = 0; row < nRows && i < len; row++) // vertically down
                sb[row].append(s.charAt(i++));
            for (int row = nRows - 2; row >= 1 && i < len; row--) // obliquely up
                sb[row].append(s.charAt(i++));
        }
        for (int row = 1; row < sb.length; row++)
            sb[0].append(sb[row]);
        return sb[0].toString();
    }
}
