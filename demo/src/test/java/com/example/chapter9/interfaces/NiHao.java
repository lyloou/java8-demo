package com.example.chapter9.interfaces;

public interface NiHao extends Hello {

    default void nihao() {
        System.out.println("nihao from NiHao");
    }

    ;
}
