package com.example.effectivejava.common;

import org.junit.Test;

import java.util.Comparator;

public class ComparatorTest {

    @Test
    public void test3() {
        Comparator<Integer> naturalOrder1 = (o1, o2) ->
                o1 < o2 ? -1 : (o1.intValue() == o2.intValue() ? 0 : 1);
        System.out.println(naturalOrder1.compare(42, new Integer(42))); // ok
    }

    @Test
    public void test2() {
        Comparator<Integer> naturalOrder1 = (o1, o2) ->
                o1 < o2 ? -1 : (o1.intValue() == o2.intValue() ? 0 : 1);
        System.out.println(naturalOrder1.compare(new Integer(42), new Integer(42))); // ok
    }

    @Test
    public void test1() {
        Comparator<Integer> naturalOrder1 = (o1, o2) ->
                o1 < o2 ? -1 : (o1 == o2 ? 0 : 1); // 如果，o1和o2都是Integer对象，那么实际上执行的是“同一性比较”
        // 也就是说：== 操作符在这里可能被误用；
        System.out.println(naturalOrder1.compare(new Integer(42), new Integer(42))); // error
    }


}
