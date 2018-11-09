package com.example.effectivejava.common;

import org.junit.Test;

import java.util.Random;

public class RandomTest {
    private static Random rnd = new Random();

    private static int random(int n) {
        return Math.abs(rnd.nextInt() % n);
    }

    @Test
    public void test1() {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);
    }

    @Test
    public void test2() {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (rnd.nextInt(n) < n /2) {
                low ++;
            }
        }
        System.out.println(low);
    }

}
