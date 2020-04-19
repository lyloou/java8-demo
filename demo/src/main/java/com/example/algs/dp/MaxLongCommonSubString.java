package com.example.algs.dp;

import java.util.Objects;

/**
 * @author lyloou
 * @date 2019/10/25
 */
public class MaxLongCommonSubString {
    public static void main(String[] args) {
        String[] a = "fishiakkj".split("");
        String[] b = "fushiabj".split("");
        System.out.println("最长公共子字符串：");
        System.out.println(count(a, b));

        System.out.println("\n最长公共子字符串序列：");
        System.out.println(countSeq(a, b));
    }

    private static int count(String[] a, String[] b) {
        int[][] arr = new int[a.length][b.length];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                arr[i][j] = getLeftTopValue(i - 1, j - 1, arr);
                if (Objects.equals(a[i], b[j])) {
                    arr[i][j] = arr[i][j] + 1;
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                    }
                }
            }
        }
        print2DArrayString(arr);
        return max;
    }

    private static int countSeq(String[] a, String[] b) {
        int[][] arr = new int[a.length][b.length];
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (Objects.equals(a[i], b[j])) {
                    arr[i][j] = getLeftTopValue(i, j, arr);
                    arr[i][j] = arr[i][j] + 1;
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                    }
                } else {
//                    arr[i][j] = Math.max(getTopValue(i, j, arr), getLeftValue(i, j, arr));
                    arr[i][j] = getTopValue(i, j, arr);
                }
            }
        }
        print2DArrayString(arr);
        return max;
    }

    private static int getLeftValue(int i, int j, int[][] arr) {
        if (j <= 0) {
            return 0;
        }
        return arr[i][j - 1];
    }


    private static int getTopValue(int i, int j, int[][] arr) {
        if (i <= 0) {
            return 0;
        }
        return arr[i - 1][j];
    }

    private static String print2DArrayString(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static int getLeftTopValue(int i, int j, int[][] arr) {
        if (i <= 0 || j <= 0) {
            return 0;
        }
        return arr[i - 1][j - 1];
    }

}
