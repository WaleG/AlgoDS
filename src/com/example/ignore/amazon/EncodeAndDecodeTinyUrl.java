package com.example.ignore.amazon;

import sun.awt.AWTCharset;

import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyUrl {
    public static void main(String[] args) {
        String s = "https://leetcode.com/problems/design-tinyurl";
        String s1 = "https://leetcode.com/problems/design-tinyurl1";
        EncodeAndDecodeTinyUrl ed = new EncodeAndDecodeTinyUrl();
        String encoded = ed.encode(s);
        String e1 = ed.encode(s1);
        System.out.println(encoded);
        String decoded = ed.decode(encoded);
        System.out.println(decoded);
    }

    Map<String, String> map = new HashMap<>();
    private Base64.Encoder e = Base64.getEncoder();

    public String encode(String longUrl) {
        String encoded = e.encodeToString(longUrl.getBytes());
        String t = encoded.substring(0, 4) + encoded.substring(encoded.length() - 4);
        map.put(t, longUrl);
        return "http://tinyurl.com/" + t;
    }

    public String decode(String shortUrl) {
        String replaced = shortUrl.replace("http://tinyurl.com/", "");
        return map.get(replaced);
    }
}
