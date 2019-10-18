package com.example.concurrent;

public class Demo {
    public Demo() {
        System.out.println("construct");
    }

    public static void main(String[] args) {
        new Demo();
    }

    {
        add();
    }

    private void add() {
        System.out.println("add");
    }
}
