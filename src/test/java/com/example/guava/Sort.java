package com.example.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    @Test
    public void test1() {
        Multiset<Integer> set = TreeMultiset.create();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(3);
        System.out.println(set.count(1));
        System.out.println(set.count(2));
        System.out.println(set.count(3));
        System.out.println(set.elementSet());
        System.out.println(set.entrySet());
        set.addAll(Arrays.asList(1, 2, 3, 4));

        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux"));

        ArrayList<Integer> objects = Lists.newArrayList();
        objects.addAll(Arrays.asList(1,2,3,4,5));
        System.out.println(objects);

    }
}
