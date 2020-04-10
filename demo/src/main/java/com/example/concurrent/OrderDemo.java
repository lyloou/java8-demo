package com.example.concurrent;

public class OrderDemo {
    int a = 0;
    int b = 0;
    int x = 0;
    int y = 0;

    public static void main(String[] args) throws InterruptedException {
        OrderDemo orderDemo = new OrderDemo();
        orderDemo.testOrder();
    }

    public void testOrder() throws InterruptedException {
        Thread ta = new Thread(() -> {
            x = b;
            a = 1;
            System.out.println("x:" + x);
        }, "a");
        Thread tb = new Thread(() -> {
            y = a;
            b = 2;
            System.out.println("y:" + y);
        }, "b");
        ta.start();
        tb.start();
//        ta.join();
//        tb.join();
    }
}
