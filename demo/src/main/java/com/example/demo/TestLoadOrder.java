package com.example.demo;

public class TestLoadOrder {
    public TestLoadOrder() {
        System.out.println("construct");
    }

    public static void main(String[] args) {
        new TestLoadOrder();
    }

    {
        System.out.println("222");
        add();
    }

    static {
        System.out.println("111");
        add();
    }

    private static void add() {
        System.out.println("add");
    }
}
