package com.example.dish;

import org.junit.Test;

import java.util.List;

import static com.example.dish.Dish.dishMenu;
import static java.util.stream.Collectors.toList;

public class Main {


    @Test
    public void test6() {
        dishMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
    }

    @Test
    public void test5() {
        List<Integer> collect = dishMenu.stream()
                .map(dish -> dish.getName().length())
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    public void test4() {
        List<String> collect = dishMenu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    public void test3() {
        int page = 2; // page 从 1 开始
        int size = 2;
        List<Dish> collect = dishMenu.stream()
                .filter(Dish::isVegetarian)
                .distinct()
                .skip((page - 1) * size)
                .limit(size)
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    public void test2() {
        List<Dish> collect = dishMenu.stream()
                .filter(Dish::isVegetarian)
                .distinct()
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    public void test1() {
        List<String> names = dishMenu.stream()
                .filter(dish -> {
                    System.out.println("filter:" + dish.getName());
                    return dish.getCalories() > 500;
                })
                .map(dish -> {
                    System.out.println("mapping:" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(names);
    }
}
