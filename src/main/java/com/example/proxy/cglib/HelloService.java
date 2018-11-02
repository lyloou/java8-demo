package com.example.proxy.cglib;

public class HelloService {
    public void print(Hello hello) {
        System.out.println("The greeting is from: " + hello.getName());
        System.out.println("The say is: " + hello.getSay());
    }

}
