package com.example.concurrent;

public class MonitorThread {
    int a = 0;

    public synchronized void write() {
        a++;
    }

    public synchronized int read() {
        return a;
    }

    public static void main(String[] args) {
        MonitorThread monitorThread = new MonitorThread();
        new Thread(() -> {
            monitorThread.write();
        }, "write").start();
        new Thread(() -> {
            System.out.println(monitorThread.read());
        }, "read").start();
    }

}
