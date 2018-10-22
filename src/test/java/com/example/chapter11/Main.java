package com.example.chapter11;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    @Test
    public void test6() {
        Code code = Code.values()[new Random().nextInt(Code.values().length)];
        System.out.println(code.name());
    }

    enum Code {
        A, B, C, D, E
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("ab", "cd", "ef");
        List<Double> collect1 = list.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> new Shop().getPrice(s)))
                // if annotate below line, will spend more time. (p231)这句话相当于两个stream。
                // 如果注释掉，就是在单一的流水线中算是流，考虑到流操作之间的延迟特性，只能以同步、顺序的方式执行。
                .collect(Collectors.toList()).stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        System.out.println(collect1);
    }

    @Test
    public void test4() {
        System.out.println(new Shop().gePriceAsync2("asd").join());
    }

    // add timeout
    @Test
    public void test3() {
        doConsume(future -> {
            try {
                return future.get(5, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                future.completeExceptionally(e);
            }
            return null;
        });
    }


    @Test
    public void test2() {
        doConsume(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                future.completeExceptionally(e);
            }
            return null;
        });
    }

    private void doConsume(Function<CompletableFuture<Double>, Double> consumer) {
        long t1 = System.currentTimeMillis();
        CompletableFuture<Double> future = new Shop().getPriceAsync("ab");
        long t2 = System.currentTimeMillis();
        System.out.println("t2-t1:" + (t2 - t1));

        System.out.println("result-sync:" + new Shop().getPrice("cd"));
        long t3 = System.currentTimeMillis();
        System.out.println("t3-t2:" + (t3 - t2));

        Double result = consumer.apply(future);
        long t4 = System.currentTimeMillis();
        System.out.println("t4-t3:" + (t4 - t3));
        System.out.println("result-async:" + result);

        if (future.isCompletedExceptionally()) {
            future.exceptionally((throwable -> {
                System.out.println(throwable);
                return null;
            }));
        }

    }

    @Test
    public void test1() {
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                latch.countDown();
                return 1234.0;
            }
        });
        try {
            Double result = future.get();
            System.out.println(result);
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class Shop {
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay(2);
        return Math.random() * product.charAt(0) + product.charAt(1);
    }

    public static void delay(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Double> getPriceAsync(String product) {
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(() -> {
            delay(10);
            future.complete(getPrice(product));
        }).start();
        return future;
    }

    public CompletableFuture<Double> gePriceAsync2(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }
}

