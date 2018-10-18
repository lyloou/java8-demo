package com.example.chapter9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        System.out.println(list);
//        removeIf(list, s -> s.equals("3"));
        list.removeIf(s -> s.equals("3"));
        System.out.println(list);
    }

    private void removeIf(List<String> list, Predicate<String> predicate) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (predicate.test(iterator.next()))
                iterator.remove();
        }
    }
}
