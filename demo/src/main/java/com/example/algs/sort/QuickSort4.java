package com.example.algs.sort;

import java.util.Arrays;

public class QuickSort4 {
    public static void main(String[] args) {
        int[] arr = {20, 8, 8, 23, 11, 23, 89, 27};
        new QuickSort4().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int low, int high) {
        // 比较 low 和 high
        if (low >= high) {
            return;
        }

        // 找枢轴
        int pivot = partition(arr, low, high);
        // 排序小于枢轴的一部分
        quickSort(arr, low, pivot - 1);

        // 排序大于枢轴的一部分
        quickSort(arr, pivot + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        // 从两边往中间找
        while (low < high) {
            // 高的往下找
            while (low < high && arr[high] >= pivot) {
                high--;
            }

            // 交换比枢轴小的
            swap(arr, low, high);

            // 低的往上找
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            swap(arr, low, high);
        }
        // 到这里 low 就是要找的枢轴了，将其返回
        return low;
    }

    private void swap(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }

}
