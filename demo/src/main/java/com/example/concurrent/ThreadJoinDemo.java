package com.example.concurrent;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread");
        }, "name");
        thread.start();

        System.out.println("main1");
        thread.join();
        System.out.println("main2");
    }

}
