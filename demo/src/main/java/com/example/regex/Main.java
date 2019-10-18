package com.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [JAVA正则表达式：Pattern类与Matcher类详解(转) - ggjucheng - 博客园](https://www.cnblogs.com/ggjucheng/p/3423731.html)
 *
 * @author lyloou
 * @date 2019/10/15
 */
public class Main {
    private static Pattern pattern = Pattern.compile("\\w+");

    public static void main(String[] args) {
        System.out.println(pattern.pattern());

        c5();
    }

    private static void c5() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("aaa22233bb");
        System.out.println(m.find());
        System.out.println(m.start());
        System.out.println(m.end());
        System.out.println(m.group());

        System.out.println("---");
        Matcher m2 = p.matcher("2223bb");
        System.out.println(m2.lookingAt());
        System.out.println(m2.start());
        System.out.println(m2.end());
        System.out.println(m2.group());

        System.out.println("----");
        p = Pattern.compile("([a-z]+)(\\d+)");
        m = p.matcher("aaa223bb");
        System.out.println(m.find());
        System.out.println(m.start(1));
        System.out.println(m.start(2));
        System.out.println(m.groupCount());
        System.out.println(m.group(1));

        System.out.println("----");
        p = Pattern.compile("\\d+");
        m = p.matcher("我的QQ是:12345 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
        while (m.find()) {
            System.out.println(m.group());
        }

        System.out.println("----");
        System.out.println(Pattern.matches("\\w+.roob.\\w+", "hekwje.roob.ekj"));
    }

    private static void c4() {
        Pattern p = Pattern.compile("\\d+");

        System.out.println(p.matcher("22bb23").lookingAt());
        System.out.println(p.matcher("bb23").lookingAt());
        System.out.println(p.matcher("bb23").find());
    }
}
