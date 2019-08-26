package com.example.algs.practice;

import edu.princeton.cs.algs4.StdOut;

public class C1 {
    public static void main(String[] args) {
//        q111();
//        q112();
//        q113(args);
//        q115();
//        q116();
//        q117a();
//        q117b();
//        q117c();
//        q118();

    }

    private static void q118() {
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    private static void q117c() {
        int sum = 0;
        for (int i = 0; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    private static void q117b() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }

        System.out.println(sum);
    }

    private static void q117a() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
            System.out.println(t);
        }
        System.out.println(String.format("%.5f\n", t));
    }

    private static void q116() {
        int f = 0;
        int g = 1;
        for (int i = 0; i < 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    private static void q115() {
        double x = 0.2;
        double y = 0.0;
        System.out.println(isBetween0And1(x) && isBetween0And1(y));
    }

    private static boolean isBetween0And1(double x) {
        if (x <= 0) {
            return false;
        }
        if (x >= 1) {
            return false;
        }
        return true;
    }

    private static void q113(String[] args) {
        if (args.length != 3) {
            System.out.println("参数不正确");
            return;
        }
        int arg0 = Integer.parseInt(args[0]);
        int arg1 = Integer.parseInt(args[1]);
        int arg2 = Integer.parseInt(args[2]);
        if ((arg0 == arg1 && arg0 == arg2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static void q112() {
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + "3");
    }

    public static void q111() {
        StdOut.println(Math.abs(-2147483648f));
        System.out.println(15 / 2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println(true && false || true && true);
    }
}
