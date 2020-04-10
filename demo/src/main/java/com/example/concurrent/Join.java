package com.example.concurrent;

import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) { // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.join();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            // thread 线程结束后，才会走到这里来
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}