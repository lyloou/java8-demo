package com.example.chapter9.interfaces;

public class HelloHi implements Hello, Hi {


    // 必须重写，因为 Hello和Hi都有hello默认方法，无法推断用哪个默认方法
    @Override
    public void hello() {
        Hi.super.hello();
        System.out.println("hello from HelloHi");
    }

    @Override
    public void hi() {
        System.out.println("hi from HelloHi");
    }
}
