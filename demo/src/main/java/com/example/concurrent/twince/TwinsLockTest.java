package com.example.concurrent.twince;

import com.example.util.Usleep;
import org.junit.Test;


public class TwinsLockTest {
    @Test
    public void test() {
        final TwinsLock lock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        Usleep.second(1);
                        System.out.println(Thread.currentThread().getName());
                        Usleep.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }// 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }// 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            Usleep.second(1);
            System.out.println();
        }
    }
}