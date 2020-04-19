package com.example.algs.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        qSort(list, 0, list.size() - 1);
        System.out.println(list);
    }

    private static void qSort(List<Integer> list, int low, int high) {
        // 比较 low 和 high
        if (low >= high) {
            return;
        }

        // 将 list 分为上下两个部分，算出枢轴位置
        int pivotPosition = partition(list, low, high);

        // 排序比枢轴小的部分
        qSort(list, low, pivotPosition - 1);

        // 排序比枢轴大的部分
        qSort(list, pivotPosition + 1, high);
    }

    private static int partition(List<Integer> list, int low, int high) {
        // 把第一个记录作为枢轴值
        int pivot = list.get(low);
        while (low < high) {
            // 从上往下找，直到小于等于枢轴值
            while (low < high && list.get(high) >= pivot) {
                high--;
            }
            // 把比枢轴值小的，交换到低端
            swap(list, low, high);

            // 从下往上找，直到大于等于枢轴值
            while (low < high && list.get(low) <= pivot) {
                low++;
            }
            // 交换到高端
            swap(list, low, high);
        }
        // low 当前的位置，就是要找的枢轴点
        return low;
    }

    private static void swap(List<Integer> list, int low, int high) {
        if (low >= high) {
            return;
        }
        int tmp = list.get(low);
        list.set(low, list.get(high));
        list.set(high, tmp);
    }
}
