package com.example.algs.util;

public class Utime {
    public static void elapsed(Runnable runnable) {
        elapsed("TAG", 1000, runnable);
    }

    public static void elapsed(String tag, Runnable runnable) {
        elapsed(tag, 1000, runnable);
    }

    public static void elapsed(String tag, int time, Runnable runnable) {
        long startAt = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            runnable.run();
        }
        long endAt = System.currentTimeMillis();
        long elasped = endAt - startAt;
        System.out.println(String.format("%s | 耗时 %s ms", tag, elasped));
    }
}
