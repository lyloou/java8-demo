package com.example.concurrent;

import java.util.concurrent.TimeUnit;

public class StopThread {
    private static boolean stopRequested;

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
