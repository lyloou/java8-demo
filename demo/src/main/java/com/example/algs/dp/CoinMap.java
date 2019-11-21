package com.example.algs.dp;

import java.util.*;

/**
 * @author lyloou
 * @date 2019/11/20
 */
public class CoinMap {
    public static void main(String[] args) {
        int[] f = new int[155];
        int n = 150;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            f[i] = getMinCost(f, i, map);
            System.out.printf("f[%d]=%d\n", i, f[i]);
        }

        printPlan(map, 15);
        printPlan(map, 26);
    }

    private static void printPlan(Map<Integer, Integer> map, int plan) {
        List<Integer> group = new ArrayList<>();
        for (int i = plan; i > 0; i = i - map.get(i)) {
            group.add(map.get(i));
        }
        Collections.reverse(group);
        System.out.println("plan-" + plan + ": " + group);
    }

    private static int getMinCost(int[] f, int i, Map<Integer, Integer> map) {
        int cost = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            if (f[i - 1] + 1 < cost) {
                cost = f[i - 1] + 1;
                map.put(i, 1);
            }
        }
        if (i - 5 >= 0) {
            if (f[i - 5] + 1 < cost) {
                cost = f[i - 5] + 1;
                map.put(i, 5);
            }
        }
        if (i - 11 >= 0) {
            if (f[i - 11] + 1 < cost) {
                cost = f[i - 11] + 1;
                map.put(i, 11);
            }
        }
        return cost;
    }
}
