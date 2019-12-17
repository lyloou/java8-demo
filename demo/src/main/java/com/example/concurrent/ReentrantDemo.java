package com.example.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Array Blocking Queue
 * 《Android 从小工到专家》 p92
 *
 * @author lyloou
 * @date 2019/11/14
 */
public class ReentrantDemo<T> {
    private T[] items;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private int head;
    private int tail;

    private int count;

    public ReentrantDemo(int maxSize) {
        //noinspection unchecked
        this.items = (T[]) new Object[maxSize];
    }

    public ReentrantDemo() {
        this(10);
    }

    public static void main(String[] args) {
        ReentrantDemo<Integer> demo = new ReentrantDemo<>();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("put:");
            for (int i = 0; i < 13; i++) {
                demo.put(i);
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("take:");
            for (int i = 0; i < 10; i++) {
                System.out.println(demo.take());
            }
        }).start();
        demo.put(12);
        demo.put(122);
        for (int i = 0; i < 5; i++) {
            System.out.println(demo.take());
        }

    }

    public void put(T t) {
        lock.lock();
        try {
            if ((count == getCapacity())) {
                System.out.println("数据已满， 等待");
                notFull.await();
            }
            items[tail] = t;
            if (++tail == getCapacity()) {
                tail = 0;
            }
            ++count;
            notEmpty.signalAll();
            int c = ((((((((((((1))))))))))));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private int getCapacity() {
        return items.length;
    }

    public T take() {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println("还没有数据， 等待");
                notEmpty.await();
            }
            T ret = items[head];
            if (++head == getCapacity()) {
                head = 0;
            }
            --count;
            notFull.signalAll();
            return ret;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public int size() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
