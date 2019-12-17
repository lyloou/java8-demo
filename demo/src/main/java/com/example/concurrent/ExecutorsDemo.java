package com.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lyloou
 * @date 2019/11/14
 */
public class ExecutorsDemo {
    private static final int MAX = 100;

    public static void main(String[] args) {
        // newThreadPool();
        newThreadPool2();
    }

    private static void newThreadPool2() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(getRunnable(), 0, 3, TimeUnit.SECONDS);
        // scheduledExecutorService.schedule(getRunnable(), 10, TimeUnit.SECONDS);
    }

    private static void run() {
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 40; i++) {
            System.out.println(fibc(i));
        }
        System.out.println(System.currentTimeMillis() - t1);
    }

    private static void newThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < MAX; i++) {
            pool.submit(getRunnable());
        }
    }

    private static Runnable getRunnable() {
        return () -> {
            System.out.println("执行线程：" + Thread.currentThread().getName()
                    + ", 结果：" + fibc2(20));
        };
    }

    private static int fibc(int count) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 1; i < count; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    private static int fibc2(int count) {
        if (count == 0 || count == 1) {
            return 1;
        }
        return fibc2(count - 1) + fibc2(count - 2);
    }

}
