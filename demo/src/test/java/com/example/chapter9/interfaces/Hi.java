package com.example.chapter9.interfaces;

public interface Hi {
    default void hello() {
        System.out.println("hello from Hi");
    }

    ;

    default void heihei() {
        System.out.println("heihei from Hi");
    }

    ;
}
