package com.example.effectivejava.common;

import org.junit.Test;

public class StringTest {
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result += i; // string is final type, they'll be copied when merged.
        }
        long end = System.currentTimeMillis();

        System.out.printf("use time=%s, length=%s", (end - start), result.length());
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            result.append(i);
        }
        long end = System.currentTimeMillis();

        System.out.printf("use time=%s, length=%s", (end - start), result.length());
    }
}
