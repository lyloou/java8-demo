package com.example.proxy.cglib;

public class Main {
    public static void main(String[] args) {
        HelloProxy proxy = new HelloProxy();
        HelloService obj = (HelloService) proxy.getProxy(HelloService.class);
        Hello hello = new Hello();
        hello.setName("Lyloou");
        hello.setSay("你好2！");
        obj.print(hello);
    }
}
