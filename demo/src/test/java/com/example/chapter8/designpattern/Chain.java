package com.example.chapter8.designpattern;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Chain {
    @Test
    public void test1() {
        UnaryOperator<String> headerProcessor = (str) -> "handle first step -> " + str.toUpperCase();
        UnaryOperator<String> secondProcessor = (str) -> "handle second step -> " + str;
        Function<String, String> handle = headerProcessor.andThen(secondProcessor);
        System.out.println(handle.apply("ye ye ye"));
    }
}
