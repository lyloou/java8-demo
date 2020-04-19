package com.example.algs.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(20, 8, 8, 23, 11, 23, 89, 27));
        sort(list);
    }

    private static void sort(List<Integer> list) {
//        System.out.println(quickSort(list));
//        System.out.println(quickSort2(list));
        Integer[] arr = list.toArray(new Integer[0]);
        quickSort3(arr, 0, list.size() - 1);
        System.out.println(Arrays.asList(arr));
    }

    private static void quickSort3(Integer[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(arr, low, high);
        quickSort3(arr, low, pivot - 1);
        quickSort3(arr, pivot + 1, high);
    }

    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            swap(arr, low, high);
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            swap(arr, low, high);
        }
        return low;
    }

    private static void swap(Integer[] list, int key1, int key2) {
        if (key1 == key2) {
            return;
        }
        int tmp = list[key1];
        list[key1] = list[key2];
        list[key2] = tmp;
    }

    private static <T extends Number> List<T> quickSort(List<T> arr) {
        if (arr.size() < 2) {
            return arr;
        }

        T a = arr.get(0);
        List<T> l1 = new ArrayList<>();
        List<T> l2 = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            T t = arr.get(i);
            if (a.doubleValue() - t.doubleValue() > 0) {
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


    private static <T extends Number> List<T> quickSort2(List<T> arr) {
        if (arr.size() < 2) {
            return arr;
        }

        T a = arr.remove(0);
        List<T> less = arr.stream().filter(t -> t.doubleValue() - a.doubleValue() < 0).collect(Collectors.toList());
        List<T> greater = arr.stream().filter(t -> t.doubleValue() - a.doubleValue() >= 0).collect(Collectors.toList());

        List<T> result = new ArrayList<>(arr.size());
        result.addAll(quickSort2(less));
        result.add(a);
        result.addAll(quickSort2(greater));
        return result;
    }

}
