package com.example.chapter9.interfaces;

public interface Hello {
    default void hello() {
        System.out.println("hello from Hello");
    }

    default void hi() {
        System.out.println("hi from Hell");
    }

}
