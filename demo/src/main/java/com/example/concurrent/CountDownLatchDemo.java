package com.example.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 是一个同步辅助类，在完成一组操作之后，而其他线程还没有完成，它允许一直等待，直到 countDown 减为0；
 * 《Android 从小工到专家》 p96
 * <p>
 * CountDownLatch VS CyclicBarrier 的区别：
 * 1. CountDownLatch 的作用是允许1个或N个线程等待其他线程执行完成，而 CyclicBarrier 则是允许N个线程相互等待；
 * 2. CountDownLatch 的计数器无法被重置， CyclicBarrier 的计数器可以被重置后使用，因此，被称为 cyclic 的 Barrier
 *
 * @author lyloou
 * @date 2019/11/14
 */
public class CountDownLatchDemo {

    public static final int SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < SIZE; i++) {
            new Thread(() -> run(latch)).start();
        }
        System.out.println("主线程等待");
        latch.await();
        System.out.println("主线程继续进行");
    }

    private static void run(CountDownLatch latch) {
        try {
            Thread.sleep(2000);
            System.out.println(String.format("线程%s，执行操作：", Thread.currentThread().getName()));
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
