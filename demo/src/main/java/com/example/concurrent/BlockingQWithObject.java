package com.example.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class BlockingQWithObject {
    public static void main(String[] args) throws InterruptedException {
        BlockingQWithObject q = new BlockingQWithObject();

        new Thread(() -> {
            q.offer(11);
        }, "a").start();
        new Thread(() -> {
            try {
                System.out.println(q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "b").start();

        new CountDownLatch(1).await();
    }

    private final Object lock = new Object();
    private Queue<Object> linkedList = new LinkedList<>();

    public Object take() throws InterruptedException {
        synchronized (lock) {
            if (linkedList.size() == 0) {
                lock.wait();
            }
            return linkedList.poll();
        }
    }

    public void offer(Object object) {
        synchronized (lock) {
            if (linkedList.size() == 0) {
                lock.notifyAll();
            }
            linkedList.add(object);
        }
    }
}