package com.example.concurrent;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        System.out.println("aaa");
        thread.setDaemon(true);
        thread.start();
        System.out.println("bbb");
        SleepUtils.second(23);
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("ccc");
                SleepUtils.second(10);
                System.out.println("ddd");
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}