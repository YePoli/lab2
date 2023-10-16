package com.example.lab2;
import java.util.StringTokenizer;

public class text {
    private String txt;

    public text(String text) {
        this.txt = text;
    }

    public int getCountOfTokens() {
        StringTokenizer tokenizer = new StringTokenizer(txt);
        return tokenizer.countTokens();
    }

    public int getCountOfChars() {
        return txt.length();
    }
}
