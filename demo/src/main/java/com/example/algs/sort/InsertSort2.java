package com.example.algs.sort;

import java.util.Arrays;
import java.util.List;

public class InsertSort2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(13, 3, 1, 10, 8, 7, 2, 3, 5);
        insertSort(list);
        System.out.println(list);
    }

    private static void insertSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            if (current >= list.get(i - 1)) {
                continue;
            }
            int j = i - 1;
            for (; j >= 0 && current < list.get(j); j--) {
                list.set(j + 1, list.get(j));
            }
            if (j + 1 != i) {
                list.set(j + 1, current);
            }
        }
    }
}
