package com.example.concurrent;

import com.example.util.Unumber;
import com.example.util.Usleep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo<T> {
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    private int maxSize;
    private List<T> lists;
    private int count;

    public static void main(String[] args) {
        int count = 100;
        ExecutorService service = Executors.newFixedThreadPool(100);
        ConditionDemo<String> demo = new ConditionDemo<>(10);

        for (int i = 0; i < count; i++) {
            int ii = i;
            Runnable runnable = () -> {
                Usleep.milliSeconds(Unumber.randomInt(10));
                demo.add("" + ii);
            };
            service.submit(runnable);
        }
        for (int i = 0; i < count; i++) {
            Runnable runnable = () -> {
                Usleep.milliSeconds(Unumber.randomInt(10));
                demo.get();
            };
            service.submit(runnable);
        }
        service.shutdown();
    }

    public ConditionDemo(int maxSize) {
        this.maxSize = maxSize;
        lists = new ArrayList<>();
    }

    public void add(T t) {
        lock.lock();
        try {
            while (count == maxSize) {
                notFull.await();
            }
            count++;
            notEmpty.signal();
            System.out.println("add:" + t + "\tcount:" + count);

            lists.add(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T get() {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            count--;
            T remove = lists.remove(0);
            notFull.signal();
            System.out.println("get:" + remove + "\tcount:" + count);
            return remove;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
