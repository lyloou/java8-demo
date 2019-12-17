package com.example.concurrent;

/**
 * @author lyloou
 * @date 2019/11/11
 */
public class ThreadYieldDemo {
    static class YieldThread extends Thread {
        YieldThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s [%d] -----> %d\n", this.getName(), this.getPriority(), i);
                if (i == 2) {
                    yield();
                }
            }
        }
    }

    public static void main(String[] args) {
        YieldThread t1 = new YieldThread("thread-t1");
        YieldThread t2 = new YieldThread("thread-t2");
        t1.start();
        t2.start();
    }

}
