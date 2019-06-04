package com.example.algs.search;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int len = a.length;
        int lo = 0;
        int hi = len - 1;
        int mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 1, 32, 8, 9, 13, 12, 18};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(rank(3, a));
    }
}
