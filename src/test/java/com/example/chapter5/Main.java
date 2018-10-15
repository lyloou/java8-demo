package com.example.chapter5;

import com.example.dish.Dish;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.example.dish.Dish.dishMenu;
import static java.util.stream.Collectors.toList;

public class Main {
    @Test
    public void test19() {
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0))
                .map(Arrays::toString)
                .forEach(System.out::println);

    }

    @Test
    public void test18() {
        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    @Test
    public void test17() {
        System.out.println(IntStream.rangeClosed(1, 100)
                .sum());
        System.out.println(IntStream.rangeClosed(1, 100)
                .count());
        System.out.println(IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0)
                .count());
    }

    @Test
    public void test16() {
        IntStream intStream = IntStream.of(1, 2, 3, 4);
        System.out.println(intStream.sum());
    }

    @Test
    public void test15() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(numbers.stream()
                .count());

        System.out.println(numbers.stream()
                .reduce(0, (a, b) -> a + b));

        System.out.println(numbers.stream()
                .reduce(0, Integer::sum));

        System.out.println(numbers.stream()
                .reduce(1, (a, b) -> a * b));


    }

    @Test
    public void test14() {
        System.out.println(dishMenu.stream()
//                .filter(Dish::isVegetarian)
                .filter(dish -> false)
                .findAny()
                .orElse(new Dish("default", true, 320, Dish.Type.OTHER)));
//                .orElseThrow(() -> new RuntimeException("asdf")));
//                .ifPresent(System.out::println);
    }

    @Test
    public void test13() {
        Function<Integer, String> a = integer -> String.valueOf(integer + ":1");
        System.out.println(a.andThen(i -> String.valueOf(i + ":2")).apply(123));
    }

    @Test
    public void test12() {
        List<String> a = Arrays.asList("a", "b", "c", "d");
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(String.join("-", a));
        System.out.println(String.join("-", b.stream().map(String::valueOf).collect(toList())));
    }

    @Test
    public void test11() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);
        System.out.println(Arrays.toString(a.toArray()));

        System.out.println(a.stream()
                .flatMap(i -> b.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .map(Arrays::toString)
                .collect(toList()));
    }

    // p89
    @Test
    public void test10() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5, 6);

        List<String> collect1 = a.stream()
                .flatMap(i -> b.stream()
                        .map(j -> new Integer[]{i, j}))
                .map(integers -> String.format("(%s)", Arrays.stream(integers)
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))))
                .collect(toList());
        System.out.println(collect1);
    }

    @Test
    public void test9() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers
                .stream()
                .map(i -> i * i)
                .collect(toList()));
    }

    @Test
    public void test8() {
        List<String> words = Arrays.asList("hello", "world");
        System.out.println(words.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList()));
    }

    @Test
    public void test7() {
        System.out.println(Arrays.stream(new String[]{"1", "2", "3"})
                .map(s -> "pre:" + s)
                .collect(toList()));
    }
}
