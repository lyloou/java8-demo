package com.example.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

// 《java并发编程艺术》C9.2.5
public class CustomThreadPoolExecutorDemo {
    public static void main(String[] args) {

//        ThreadPoolExecutor pool = getSynchronousExecutor();
        ThreadPoolExecutor pool = getCustomExecutor();

        for (int i = 0; i < 50; i++) {
            pool.submit(CustomThreadPoolExecutorDemo::doSomething);
        }

        pool.shutdown();
    }

    private static ThreadPoolExecutor getCustomExecutor() {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(20);
        return new CustomThreadPoolExecutor(4, 15, 0, TimeUnit.SECONDS,
                workQueue, new ThreadPoolExecutor.DiscardPolicy());
    }

    private static void doSomething() {
//        System.out.println(Thread.currentThread().getName());
    }

    private static ThreadPoolExecutor getSynchronousExecutor() {
        return new ThreadPoolExecutor(0,
                Integer.MAX_VALUE,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadFactoryBuilder()
                        .setNameFormat("XX-task-%d")
                        .build());
    }

    public static class CustomThreadPoolExecutor extends ThreadPoolExecutor {
        public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }

        public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        }

        public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            super.beforeExecute(t, r);
            printCurrentPoolState("==>beforeExecute");
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            super.afterExecute(r, t);
//            printCurrentPoolState("==>afterExecute");
        }

        @Override
        protected void terminated() {
            super.terminated();
            printCurrentPoolState("==>terminated");
        }

        private synchronized void printCurrentPoolState(String from) {
            System.out.println(from);
            System.out.println("getActiveCount:" + getActiveCount());
            System.out.println("getLargestPoolSize:" + getLargestPoolSize());
            System.out.println("getMaximumPoolSize:" + getMaximumPoolSize());
            System.out.println("getPoolSize:" + getPoolSize());
            System.out.println("getTaskCount:" + getTaskCount());
            System.out.println("getCompletedTaskCount:" + getCompletedTaskCount());
        }


    }
}
