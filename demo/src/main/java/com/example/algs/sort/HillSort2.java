package com.example.algs.sort;

import java.util.Arrays;
import java.util.List;

public class HillSort2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(13, 3, 1, 10, 8, 7, 2, 3, 5);
        insertSort(list);
        System.out.println(list);
    }

    private static void insertSort(List<Integer> list) {
        int increment = list.size();
        for (; increment > 1; ) {
            increment = increment / 3 + 1;
            for (int i = increment; i < list.size(); i++) {
                int current = list.get(i);
                if (current >= list.get(i - increment)) {
                    continue;
                }
                int j = i - increment;
                for (; j >= 0 && current < list.get(j); j = j - increment) {
                    list.set(j + increment, list.get(j));
                }
                list.set(j + increment, current);
            }
        }
    }
}
