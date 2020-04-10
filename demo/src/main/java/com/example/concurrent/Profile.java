package com.example.concurrent;

public class Profile {
    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<>();

    public static void begin() {
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
    }

    public static void main(String[] args) {
        System.out.println(Profile.TIME_THREAD_LOCAL.get());
        Profile.begin();
        System.out.println(Profile.TIME_THREAD_LOCAL.get());
        SleepUtils.second(1);
        System.out.println(Profile.end());
    }
}
