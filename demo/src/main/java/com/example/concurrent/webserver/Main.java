package com.example.concurrent.webserver;

// 《Java并发编程艺术》第四章
public class Main {
    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir");
        path = path.replace("\\", "/");
        path += "/demo/src/main/java/";
        path += Main.class.getPackage().getName().replace(".", "/");
        System.out.println(path);
        SimpleWebServer.setBasePath(path);
        SimpleWebServer.setBasePath("D:\\w\\java\\java8-demo\\demo\\src\\main\\java\\com\\example\\concurrent\\webserver");
        SimpleWebServer.start();
    }
}
