package com.example.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class StopThreadWithAtomic {
    private static final AtomicLong nextSerialNum = new AtomicLong();

    private static long generateSerialNumber() {
        return nextSerialNum.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(10);
        Thread thread = new Thread(() -> {
            while (generateSerialNumber() < 10) {
                latch.countDown();
                System.out.println(latch.getCount());
            }
        });
        thread.start();

        latch.await();
    }
}
