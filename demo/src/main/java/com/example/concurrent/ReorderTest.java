package com.example.concurrent;

public class ReorderTest {
    public static void main(String[] args) {

        ReorderTest reorderTest = new ReorderTest();
        for (int i = 0; i < 100; i++) {
            String a = reorderTest.getA();
            String b = reorderTest.getB();
            String c = a + b;
            System.out.println(c);
        }
    }

    public String getA() {
        System.out.println("a");
        return "a";
    }

    public String getB() {
        System.out.println("b");
        return "b";
    }
}
