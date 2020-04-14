package com.example.concurrent;

import com.example.util.Usleep;

public class NotifyDemo {
    private static final Object lock = new Object();

    public static void main(String[] args) {
//        waitWithTimeout();
        waitWithNotify();
    }

    private static void waitWithTimeout() {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("bbb");
                    lock.wait(100);
                    // 100 ms 后会尝试获取锁，由于线程b在占用，得等到它执行完成后，才会接着走
                    System.out.println("aaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("asdfsasdf");
            }
        }, "a").start();
        new Thread(() -> {
            // b线程会占用 3s
            synchronized (lock) {
                Usleep.second(3);
            }
        }, "b").start();
    }

    private static void waitWithNotify() {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("bbb");
                    lock.wait();
                    System.out.println("aaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("asdfsasdf");
            }
        }, "a").start();
        new Thread(() -> {
            synchronized (lock) {
                Usleep.second(3);
                lock.notify();
            }
        }, "b").start();
    }

}
