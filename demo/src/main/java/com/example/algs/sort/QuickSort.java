package com.example.algs.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 8, 8, 23, 11, 23, 89, 27));
        sort(list);
    }

    private static void sort(List<Integer> arr) {
        System.out.println(quickSort(arr));
        System.out.println(quickSort2(arr));
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable> List<T> quickSort(List<T> arr) {
        if (arr.size() < 2) {
            return arr;
        }

        T a = arr.get(0);
        List<T> l1 = new ArrayList<>();
        List<T> l2 = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            T t = arr.get(i);
            if (a.compareTo(t) > 0) {
                l1.add(t);
            } else {
                l2.add(t);
            }
        }

        List<T> ts = quickSort(l1);
        ts.add(a);
        ts.addAll(quickSort(l2));
        return ts;
    }


    @SuppressWarnings("unchecked")
    private static <T extends Comparable> List<T> quickSort2(List<T> arr) {
        if (arr.size() < 2) {
            return arr;
        }

        T a = arr.remove(0);
        List<T> less = arr.stream().filter(t -> t.compareTo(a) < 0).collect(Collectors.toList());
        List<T> greater = arr.stream().filter(t -> t.compareTo(a) >= 0).collect(Collectors.toList());

        List<T> result = new ArrayList<>(arr.size());
        result.addAll(quickSort(less));
        result.add(a);
        result.addAll(quickSort(greater));
        return result;
    }

}
