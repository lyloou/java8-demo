package com.example.concurrent;

public class SingleInstanceWithDoubleCheck {

    // java并发编程艺术（C3.8.3）
    // volatile 不能少
    // （否则 instance=new SingleInstanceWithDoubleCheck() 这个赋值可能会有问题，
    // 重排序可能导致内存分配和初始化顺序不一样，如果内存分配在前，另一个线程可能会取到一个尚未初始化的实例）
    private static volatile SingleInstanceWithDoubleCheck instance;

    public SingleInstanceWithDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingleInstanceWithDoubleCheck.class) {
                instance = new SingleInstanceWithDoubleCheck();
            }
        }
        return instance;
    }

    private SingleInstanceWithDoubleCheck() {
    }
}
