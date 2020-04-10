package com.example.concurrent;

public class SingleInstanceWithStaticInnerClass {
    // java并发编程艺术（C3.8.4）
    // 基于类初始化的解决方案
    public static class SingleInstanceHolder {
        private static SingleInstanceWithStaticInnerClass instance = new SingleInstanceWithStaticInnerClass();
    }

    public SingleInstanceWithStaticInnerClass getInstance() {
        return SingleInstanceHolder.instance;
    }

    private SingleInstanceWithStaticInnerClass() {
    }
}
