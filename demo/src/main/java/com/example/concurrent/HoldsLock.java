package com.example.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// https://www.cnblogs.com/dolphin0520/p/3958019.html
// https://javarevisited.blogspot.com/2014/07/top-50-java-multithreading-interview-questions-answers.html
// 29)

public class HoldsLock {

    HoldsLock h = new HoldsLock() {{

    }};

    public static class A {
        private volatile int a;

        public void withSyn(CountDownLatch latch) {
            a = 0;
            for (int i = 0; i < latch.getCount(); i++) {
                new Thread(() -> {
                    synchronized (this) {
                        doSomething(latch);
                    }
                }).start();
            }

        }

        public void withoutSyn(CountDownLatch latch) {
            for (int i = 0; i < latch.getCount(); i++) {
                new Thread(() -> {
                    doSomething(latch);
                }).start();
            }

        }

        private void doSomething(CountDownLatch latch) {
            System.out.println("holds lock: " + Thread.holdsLock(this));

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(++a + "\n");
            latch.countDown();
        }
    }

    @Test
    public void testHoldsLock() throws InterruptedException {
        int count = 15;
        CountDownLatch latch = new CountDownLatch(count);
//        new A().withSyn(latch);
        new A().withoutSyn(latch);
        latch.await();
    }
}
