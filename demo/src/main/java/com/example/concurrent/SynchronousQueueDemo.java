package com.example.concurrent;

import com.example.util.Unumber;
import com.example.util.Usleep;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    private static final SynchronousQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put("a");
                    System.out.println("put");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.submit(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Usleep.milliSeconds(Unumber.randomInt(500));
                    System.out.println("get:" + queue.take());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();


    }

}
