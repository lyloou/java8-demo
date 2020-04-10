package com.example.concurrent;

public class DeadLock {
    private final String A = "A";
    private final String B = "B";

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }

    private void deadLock() {
        new Thread(() -> {
            synchronized (A) {
                sleep(1000);
                synchronized (B) {
                    System.out.println("from thread1");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (B) {
                sleep(1000);
                synchronized (A) {
                    System.out.println("from thread2");
                }
            }
        }).start();
    }

    private void sleep(int l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
