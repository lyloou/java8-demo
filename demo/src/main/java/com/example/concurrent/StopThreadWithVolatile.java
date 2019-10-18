package com.example.concurrent;

import java.util.concurrent.TimeUnit;

public class StopThreadWithVolatile {
    private static volatile boolean stopRequested;


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
