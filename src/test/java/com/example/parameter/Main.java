package com.example.parameter;

public class Main {
    public static void main(String[] args) {
        // http://xinklabi.iteye.com/blog/837435
        System.out.println("\n==> sun.boot.class.path:");
        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println("\n==> java.ext.dirs:");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("\n==> java.class.path:");
        System.out.println(System.getProperty("java.class.path"));

        // cd src/test/java
        // javac com/example.parameter/Main.java
        // java -Dnihao=hello com/example.parameter/Main
        System.out.println("\n==> nihao:");
        System.out.println(System.getProperty("nihao"));
    }
}
