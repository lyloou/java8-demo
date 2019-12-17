package com.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 《Android 从小工到专家》 p93
 *
 * @author lyloou
 * @date 2019/11/14
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("剩余许可：" + semaphore.availablePermits());
                    Thread.sleep(2000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
