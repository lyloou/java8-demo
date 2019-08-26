package com.example.chapter8;

import com.example.dish.Dish;
import com.example.logger.Ulogger;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.example.dish.Dish.dishMenu;

public class Main {
    @Test
    public void test2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .peek(i -> System.out.println("from stream: " + i))
                .map(i -> i + 1)
                .peek(i -> System.out.println("after map: " + i))
                .filter(i -> i < 5)
                .peek(i -> System.out.println("after filter:" + i))
                .forEach(System.out::println);
    }

    @Test
    public void test1() {
        Runnable r = () -> System.out.println("kdsj" + Thread.currentThread().getName());
        r.run();

        System.out.println(dishMenu.stream()
                .collect(Collectors.groupingBy(Dish::getCaloricLevel)));

        Logger.getGlobal().setLevel(Level.INFO);
        Ulogger.log(Logger.getGlobal(), Level.INFO, () -> "hist");

    }

}
