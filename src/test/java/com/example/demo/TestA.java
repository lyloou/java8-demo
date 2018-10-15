package com.example.demo;

import org.junit.Test;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class TestA {
    @Test
    public void hello() throws Exception {
        System.out.println("hello");

        new Thread(() -> System.out.println("world")).start();

        FutureTask<Integer> future = new FutureTask<>(() -> 123);
        future.run();
        System.out.println(future.get());
        PrintStream out = System.out;
        doPrint(out, "helo");
        doRunnable(() -> out.println("hie"));

        String integer = doCallable(() -> 1234);
        System.out.println(integer);
    }

    private void doRunnable(Runnable r) {
        r.run();
    }

    private <V> String doCallable(Callable<V> r) throws Exception {
        return "->" + r.call();
    }

    private void doPrint(PrintStream stream, String str) {
        stream.println(str);
    }
}
