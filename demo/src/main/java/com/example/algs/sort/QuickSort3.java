package com.example.algs.sort;


import com.example.util.Utime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort3 {

    private final static String TAG = QuickSort3.class.getName();

    public static void main(String[] args) {

        int[] largeArr = {18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12, 18, 5, 4, 1, 3, 5, 8, 9, 10, 12};
        List<Integer> a = Arrays.stream(largeArr).boxed().collect(Collectors.toList());

        Utime.elapsed("数组-Java库实现", () -> Arrays.sort(largeArr));
        Utime.elapsed("列表-Java库实现", () -> a.sort(Integer::compareTo));
        Utime.elapsed("列表-元素追加", () -> sortWithAppend(a));
        Utime.elapsed("数组-分割交换", () -> sortInPlace(largeArr));

    }

    // https://zh.wikipedia.org/wiki/快速排序#原地（in-place）分割的版本
    private static void sortInPlace(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (right > left) {
            int pivotIndex = partition(arr, left, right, left);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] a, int left, int right, int pivotIndex) {
        int pivotValue = a[pivotIndex];
        swap(a, right, pivotIndex);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (a[i] < pivotValue) {
                swap(a, storeIndex, i);
                storeIndex++;
            }
        }
        swap(a, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    // https://zh.wikipedia.org/wiki/快速排序
    private static List<Integer> sortWithAppend(List<Integer> a) {
        int len = a.size();
        if (len <= 1) {
            return a;
        }

        List<Integer> loList = new ArrayList<>();
        List<Integer> hiList = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            if (a.get(0) < a.get(i)) {
                hiList.add(a.get(i));
            } else {
                loList.add(a.get(i));
            }
        }
        List<Integer> list1 = sortWithAppend(loList);
        List<Integer> list2 = sortWithAppend(hiList);
        return new ArrayList<Integer>() {{
            addAll(list1);
            add(a.get(0));
            addAll(list2);
        }};
    }
}
