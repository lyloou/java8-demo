package com.example.apple;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        int c = 1;
        c = 2;
        int finalC = c;
        Runnable r = () -> System.out.println(finalC);
        List<Apple> apples = Arrays.asList(
                new Apple("black", 1.2),
                new Apple("red", 1.2),
                new Apple("black", 2.8),
                new Apple("white", 1.3),
                new Apple("yellow", 6.2),
                new Apple("red", 8.2)
        );

//        test1(apples);
        test2(apples);
    }

    private static void test2(List<Apple> apples) {
        System.out.println(apples.stream()
                .filter(apple -> apple.getWeight() > 2)
                .filter(apple -> apple.getColor().equals("red"))
                .collect(toList()));
    }

    private static void test1(List<Apple> apples) {
        List<Apple> apples1 = filterApple(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 2;
            }
        });
        System.out.println(apples1);
    }

    private static List<Apple> filterApple(List<Apple> apples, ApplePredicate predicate) {
        for (Apple apple : apples) {
            if (!predicate.test(apple)) {
                apples.remove(apple);
            }
        }
        return apples;

//        List<Apple> appleList = new ArrayList<>();
//        for (Apple apple : apples) {
//            if (predicate.test(apple)) {
//                appleList.add(apple);
//            }
//        }
//        return appleList;
    }
}
