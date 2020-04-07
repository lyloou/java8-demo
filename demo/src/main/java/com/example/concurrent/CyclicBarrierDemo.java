package com.example.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 《Android 从小工到专家》 p95
 *
 * @author lyloou
 * @date 2019/11/14
 */
public class CyclicBarrierDemo {
    private static final int SIZE = 5;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(SIZE, () -> {
            // 只有在 SIZE 个线程都执行 await 之后，后续的代码都会执行
            System.out.println("满足条件，执行特定操作，参与者数量：" + cyclicBarrier.getParties());
        });
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println(String.format("线程%s, 等待 CyclicBarrier", threadName));
                // 将 cyclicBarrier 参与数量加 1
                try {
                    cyclicBarrier.await();
                    System.out.println(String.format("线程%s, 继续进行", threadName));
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    static void runOneTime2() {
        List<String> list = new ArrayList<>();

        int parties = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, () -> {
            System.out.println("all done");
            System.out.println(list);
        });

        for (int i = 0; i < parties; i++) {
            final int r = i;
            new Thread(() -> {
                System.out.println("do:i" + r);
                list.add(Thread.currentThread().getName() + "," + r);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "i:" + i).start();
        }
    }
}
