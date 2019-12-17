package com.example.algs.leetcode._023mergeKLists;

/**
 * @author lyloou
 * @date 2019/12/16
 */

import java.util.Arrays;

import static com.example.algs.leetcode._023mergeKLists.ListNode.getNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solutions3 {
    public static void main(String[] args) {
        // [[-10,-9,-9,-9,-7,-2,-1,2,4],[-9,-7,-6,-6,-3,0,1,3],[-10,-9,-2,-1,1,3]]
        System.out.println(new Solutions3().mergeKLists(new ListNode[]{
                getNode(Arrays.asList(-10, -9, -9, -9, -7, -2, -1, 2, 4)),
                getNode(Arrays.asList(-9, -7, -6, -6, -3, 0, 1, 3)),
                getNode(Arrays.asList(-10, -9, -2, -1, 1, 3))}));

        System.out.println(new Solutions3().mergeKLists(new ListNode[]{
                getNode(Arrays.asList(1, 4, 5)),
                getNode(Arrays.asList(1, 3, 4)),
                getNode(Arrays.asList(2, 6))}));
    }

    // 合并到第一个非空列表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode result = null;
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            if (result == null) {
                result = node;
            } else {
                mergeNode(result, node);
            }
        }
        return result;
    }

    private void mergeNode(ListNode first, ListNode second) {
        ListNode previousOuter = null;
        while (first != null && second != null) {
            ListNode previousInner = null;
            // 交换
            while (second != null && first.val > second.val) {
                // 插入 val
                insert(previousInner, first, second.val);
                second = second.next;
                previousInner = first;
            }
            previousOuter = first;
            first = first.next;
        }

        // 插入剩下的（second还没有放完）
        if (first == null && previousOuter != null) {
            previousOuter.next = second;
        }

    }

    private void insert(ListNode previous, ListNode first, int val) {
        // 插入到头部
        if (previous == null) {
            // 原先的第一个变成了第二个
            ListNode second = new ListNode(first.val);
            second.next = first.next;
            // 新加的成为第一个
            first.val = val;
            first.next = second;
            return;
        }

        // 插入中间或尾部
        ListNode node = new ListNode(val);
        node.next = first.next;
        first.next = node;
    }
}