package com.example.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeDemo {
    private static final Exchanger<String> expr = new Exchanger<>();
    private static final ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        service.submit(() -> {
            String B = "银行流水B";
            try {
                String A = expr.exchange("阿斯蒂芬");
                System.out.println("A和B数据是否一致：" + A.equals(B) + ", A录入的是：" + A + ", B录入的是：" + B);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.submit(() -> {
            String A = "银行流水A";
            try {
                // 把A给到上面的线程，并获取上面线程给的值
                String a = expr.exchange(A);
                System.out.println("from another:" + a);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        service.shutdown();
    }

}
