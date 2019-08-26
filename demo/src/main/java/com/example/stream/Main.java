package com.example.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    @Test
    public void test5() {
        IntStream.generate(() -> 1)
                .limit(13)
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        Stream.iterate(1, num -> num + 2)
                .limit(10)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void test1() {
        System.out.println(Paths.get("data.txt").toAbsolutePath().toString());
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset());) {
            System.out.println(lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
