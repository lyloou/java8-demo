package com.example.proxy.jdk;

public class Main {
    public static void main(String[] args) {
        HelloProxy proxy = new HelloProxy();
        HelloService service = (HelloService) proxy.bind(new HelloServiceImpl());
        Hello hello = new Hello();
        hello.setName("Lyloou");
        hello.setSay("你好啊！");
        service.print(hello);
    }
}
